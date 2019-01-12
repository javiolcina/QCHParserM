package es.jaolve.QCHParserM.cor.artistes;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.Params;
import es.jaolve.QCHParserM.MongoDB.DTO.ArtistesMongoDto;
import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.input.document.DocumentAbstract;
import es.jaolve.QCHParserM.input.parsers.ParserGeneric;
import es.jaolve.QCHParserM.net.JGet;
import es.jaolve.QCHParserM.net.html.Html2Text;
import es.jaolve.QCHParserM.output.event.Event;

/**
 * Lógica de negoci del cor de QCHParser associada a artistes
 * 
 * @author jaolve
 *
 */
public class Artistes {
	

	//Lista estática de artistes
	private static List <Artiste> artistes 		= new Vector<Artiste>();
	private static List <String> complementCom 	= new Vector<String>();
	
	final static Logger logger = Logger.getLogger(Artistes.class);
	
	/*public static int carregaArtistes()
	{
		//TODO: això haurà de ser carregat de fitxer
		Vector<String> botiNames = new Vector();
		botiNames.add("boti");
		artistes.add(new ArtistaParsing("Pep Gimeno \"Botifarra\"", botiNames,null));
		
		return artistes.size();
	}*/
	
	/*public static int carregaComplementComArtista()
	{
		//TODO: això haurà de ser carregat de fitxer
		complementCom.add("en solitari");
		complementCom.add("a banda");
		complementCom.add("ensemble");
		complementCom.add("rondalla");
		complementCom.add("grup"); //Tb grupo
		
		return artistes.size();
	}*/
	
	/**
	 * Carrega la llista d'artistes from Mongo
	 * @return
	 */
	public static int carregaArtistaFromMongo()
	{
		ArtistesMongoDto artistesMongoDto = new ArtistesMongoDto();
		
		artistes = artistesMongoDto.getArtistes();
		return artistes.size();
	}
	
	/**
	 * Torna el numero de artistes carregats
	 * 
	 * @return
	 */
	public static int getNumArtistesCarregats()
	{
		return artistes.size();
	}
	
	/**
	 * Imprimeix els artistes carregats
	 * 
	 */
	public static void artistesToString()
	{
		for (Artiste artiste : artistes) 
			logger.debug( artiste.toString() );
	}
	
	
	
	/**
	 * Carrega AltresOrigents d'un JSON i torna quants ha carregat
	 * 
	 * @return
	 */
	/*public static int loadFromJson()
	{
		try
		{
			//Create a new Gson object
	        Gson gson = new Gson();
	        
	        //Read the employee.json file
            BufferedReader br = new BufferedReader(  
                    new FileReader
                    ("E:\\jolcina\\fuentes\\workspaceJava2017\\QCHParserM\\src\\main\\artistes\\artistes.json"));

           ArtistaParsing[] artistesArray = gson.fromJson(br, ArtistaParsing[].class);
           artistes = Arrays.asList(artistesArray);
           
           
           return artistes.size();
		}
        catch (IOException e) 
        {  
            logger.error("Error carregant fitxer AltresOrigents"+ e.toString());
            return 0;
        }  
	}*/

	/**
	 * Torna Events a partir d'una pagina dun artista
	 * 
	 * @param artistaURL
	 * @return
	 */
	public static List <Event> getEventsFromArtistaURL(Artiste artiste) {
		String url = artiste.getUrl();
		String nomArtistas = artiste.getNom();
		if (url != null)
		{
			StringReader reader = new StringReader(JGet.getHTML(url));
		    String text = Html2Text.textFromURL(reader);
		    
		    reader.close();  
		    //artiste.getClasse();
		    
		    Class<?> classDoc;
		    Class<?> classParser;
			try {
				classDoc = Class.forName("es.jaolve.QCHParserM.input.document.DocumentGeneric");
			    DocumentAbstract document = (DocumentAbstract) classDoc.newInstance();
			    document.setMarcaSeparacio(artiste.getMarca_seccio());
			    document.setParsing_ini(artiste.getParsing_ini());
			    document.setParsing_fin(artiste.getParsing_fi());
			    document.setContingut(text);
			    if (Params.DEBUG_TEXT) logger.debug(document.getContingut());
			    //logger.debug( "Text: "+document.getContingut() );
			    classParser = Class.forName("es.jaolve.QCHParserM.input.parsers.ParserGeneric");
			    ParserGeneric parser = (ParserGeneric) classParser.newInstance();
			    parser.setDocument(document);
		        List<Event> listaEventsBoti = parser.getEvents(artiste);
		        logger.info( "QCHParser: Events: "+listaEventsBoti.size() );
		        logger.info( "QCHParser: Events: "+listaEventsBoti);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
		}
		return null;
	}
	/**
	 * Busca un artista que corresponga a 
	 * 
	 * @param artista
	 * @return
	 */
	public static Artiste getArtistaFromString(String artistaStr) {
		
		Iterator<Artiste> it = artistes.iterator();
		Artiste artistaTrobat = null;
		Artiste artista = null;
		//Recorreguem tots els artistes
		while (it.hasNext() && artistaTrobat == null) {
			artista = (it.next()); 
			if (ArtistaParsing.isArtistaNom(artista,artistaStr))
			{
				artistaTrobat = artista;
				logger.debug("getArtistaFromString("+artistaStr+")="+artista.getNom());
			}
		}
		
		return artistaTrobat;
	}
	
	/**
	 * Busca un espectacle per un artista concret 
	 * 
	 * @param artiste
	 * @param espectacleStr
	 * @return
	 */
	public static String getEspectaclePerArtistaFromString(Artiste artiste,String espectacleStr) {
		String espectacle 			= ArtistaParsing.getArtistaEspectacle(artiste, espectacleStr);

		if (espectacle != null)
		{
			logger.debug("getEspectaclePerArtistaFromString("+artiste.getNom()+","+espectacleStr+")="+espectacle);
		}
		else
			espectacle = "";
		return espectacle;
	}

}
