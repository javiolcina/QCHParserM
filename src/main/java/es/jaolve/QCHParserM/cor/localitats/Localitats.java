package es.jaolve.QCHParserM.cor.localitats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import es.jaolve.QCHParserM.MongoDB.DTO.ArtistesMongoDto;
import es.jaolve.QCHParserM.MongoDB.DTO.LocalitatMongo;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;
import es.jaolve.QCHParserM.cor.paraules.SintagmaUtils;
import es.jaolve.QCHParserM.input.Fitxers;
import es.jaolve.QCHParserM.input.localitats.LlocsQCH;
import es.jaolve.QCHParserM.input.municipis.MunicipioJson;

public class Localitats {
	
	final static Logger logger = Logger.getLogger(Localitats.class);

	//Lista estática de localitats
	private static List <Localitat> localitats 		= new Vector<Localitat>();
	public static List <Localitat> localitatsPV  	= new Vector<Localitat>();
	private static List <Localitat> localitatsCat  	= new Vector<Localitat>();
	private static List <Localitat> localitatsIB		= new Vector<Localitat>();
	
	//private static List <String> llocsEnCru  		= new Vector<String>();

	private static HashSet<String> codProvinciesPV = new HashSet<String>();
	private static HashSet<String> codProvinciesCat = new HashSet<String>();
	private static HashSet<String> codProvinciesIB = new HashSet<String>();
	
	private static Vector<String> vies = new Vector<String>();
	
	static
	{
		codProvinciesPV.add("46"); //València
		codProvinciesPV.add("03"); //Alacant
		codProvinciesPV.add("12"); //Castelló
		
		codProvinciesCat.add("43"); //Tarragona
		codProvinciesCat.add("08"); //Barcelona
		codProvinciesCat.add("25"); //Leida
		codProvinciesCat.add("17"); //Girona
		
		codProvinciesCat.add("07"); //Balears
	}
	

	/**
	 * Métode que intenta fer una cerca d'informació de lloc a la secció
	 * 
	 * @param seccio
	 * @return
	 */
	/*public static String getLloc(String seccio) {
		
		int i = 0;
		//recorreguem totes les localitats per buscar conincidències
		//TODO Cal tindre en compte els sinonims
		while (i<localitats.size() && seccio.indexOf(localitats.get(i).getNom())==-1)
		{
			i++;
		}
		if (i<localitats.size())
			return localitats.get(i).getNom();
		else
		{
			logger.warn("seccio sense Lloc trobat");
			return "";
		}
	}*/
	
	/**
	 * Carrega les llistes de Localitats a partir de un JSON
	 * Métode per a un càrrega inicial a partir del fitxer
	 * 
	 * @return
	 */
	public static int[] loadLocalitatsFromMunicipiosFile()
	{
		int[] results = new int[4];
		try
		{
	        Gson gson = new Gson();
	        
            BufferedReader br = new BufferedReader(  
                    new FileReader
                    (Fitxers.MUNICIPIOS_FILE));

           MunicipioJson[] municipiosArray = gson.fromJson(br, MunicipioJson[].class);
           localitats = toLocalitats(Arrays.asList(municipiosArray));
           results[0] = localitats.size();
           
           localitatsPV =  filtreLocalitats(localitats,codProvinciesPV);
           results[1] = localitatsPV.size();
           
           localitatsCat =  filtreLocalitats(localitats,codProvinciesCat);
           results[2] = localitatsCat.size();
           
           localitatsIB =  filtreLocalitats(localitats,codProvinciesIB);
           results[3] = localitatsIB.size();
           
           return results;
		}
        catch (IOException e) 
        {  
            logger.error("Error carregant fitxer Municipis"+ e.toString());
            return results;
        }  
	}
	

	public static int loadTipusVies()
	{
		int result = 0;

		vies =  LocalitatsUtils.carregarTipusVies();
		result  = vies.size();
		   
		logger.debug("loadTipusVies:"+result);
		return result ;
 
	}
	
	/**
	 * Filtra per codprovincia (dos digits), si no hi ha codPrivincies torna tot
	 * 
	 * @param municipisO
	 * @param codProvincies
	 * @return
	 */
	public static List<Localitat> filtreLocalitats(List<Localitat> localitatsO, 
									HashSet<String> codProvincies)
	{
        List <Localitat> localitatsResult = new Vector<Localitat>();
		
		//Recorreguem els localitats
		Iterator i = localitatsO.iterator();
		
		for (Localitat m : localitatsO) {
			if (codProvincies.contains(m.getId().substring(0,2)))
			{
				localitatsResult.add(m);
				//logger.debug("Afegit:"+m.getId()+"-"+m.getNm());
			}	
		}
		
		return localitatsResult;
	}
	
	
	/**
	 * coverteix List de MunicipioJson a List de Localitat
	 * 
	 * @param municipios
	 * @return
	 */
	public static List<Localitat> toLocalitats(List<MunicipioJson> municipios)
	{
		Vector<Localitat> lista = new Vector<Localitat>();
		
		for (int i = 0; i < municipios.size(); i++) {
			lista.addElement((new Localitat(municipios.get(i))));	
		}

		return lista;
	}


	/**
	 * Intenta detectar un lloc
	 * 
	 * @param llocStr
	 * @return
	 */
	public static Localitat isMunicipiFromString(String llocStr) {
		Iterator<Localitat> it = localitats.iterator();
		Localitat llocTrobat = null;
		Localitat lloc = null;
		//busquem referencia exacta
		while (it.hasNext() && llocTrobat == null) {
			lloc = (it.next()); 
			if (lloc.teLocalitat(llocStr,false))
				llocTrobat = lloc;
		}
		
		return llocTrobat;
	}

	/** 
	 * Intenta detectar si dins del String es pot trobar Localitat
	 * 
	 * @param llocStr
	 * @return
	 */
	public static Localitat teLocalitat(String llocStr) {
		Iterator<Localitat> it = localitatsPV.iterator();
		Localitat llocTrobat = null;
		Localitat lloc = null;
		//Búsqueda exacta
		while (it.hasNext() && llocTrobat == null) {
			lloc = (it.next()); 
			if (lloc.teLocalitat(llocStr,true) )
				llocTrobat = lloc;
		}
		//Búsqueda aproximada
		while (it.hasNext() && llocTrobat == null) {
			lloc = (it.next()); 
			if (lloc.teLocalitat(llocStr,true) ||  lloc.teLocalitat(llocStr,false))
				llocTrobat = lloc;
		}
		return llocTrobat;
	}

	/** 
	 * Intenta detectar si dins del String es pot trobar un lloc
	 * basat en la carrega de llocs en brut del calendari
	 * 
	 * @param llocStr
	 * @return
	 */
	/*public static String teLlocEnBrut(String llocStr) {
		String resultado = null;

		for (int i = 0; i < llocsEnCru.size() && resultado==null; i++) {
 
			if (llocStr.indexOf(llocsEnCru.get(i))!=-1  
					|| SintagmaUtils.sintagmesIguals(llocsEnCru.get(i), llocStr, 75, 1))
			resultado = llocsEnCru.get(i);	
		}
	    
	    return resultado;
	}*/
	
	/**
	 * Comprova si un token es carrer
	 * 
	 * @param token
	 * @return
	 */
	public static boolean esCarrerToken(String token)
	{ 
		boolean resultado = false;

		for (int i = 0; i < vies.size() && !resultado; i++) {
 
			if (token.equalsIgnoreCase(vies.get(i)))
				resultado = true;
		}
	    
	    return resultado;
	}

	/**
	 * 
	 * 
	 * @param id
	 * @param strLine
	 */
	public static void addLlocToLocalitat(String id, String lloc) {
		boolean trobat = false;
		int i = 0;
		while(!false && i<localitatsPV.size())
		{
			if (id.equals(localitatsPV.get(i).getId()))
				localitatsPV.get(i).addLlocs(lloc);
			i++;
		}
		
	}

	public static void buscaLlocsPerLocalitats() {
		List <String> llocsEnCru = LlocsQCH.loadLlocs();

		
		for (String llocCru : llocsEnCru) {
			/* Para cada localitat
			 * for ({
				
			}*/
		}
		
	}


	public static void toMongo() {
		LocalitatMongo localitatMongoDto = new LocalitatMongo();
		localitatMongoDto.localitatToMongo(localitatsCat.get(5));
		
	}
}
