package es.jaolve.QCHParserM;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
//import org.ocpsoft.prettytime.PrettyTime;
//import org.ocpsoft.prettytime.nlp.PrettyTimeParser;

import es.jaolve.QCHParserM.MongoDB.DTO.ArtistesMongoDto;
import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.cor.artistes.Artistes;
import es.jaolve.QCHParserM.cor.localitats.Localitats;
import es.jaolve.QCHParserM.localitats.generador.GeneradorLlocsLocalitats;

/**
 * Classe principal del parsejador del QCH
 * 
 * Aquesta ferramenta preten parsejar concerts automàticament
 *
 */

public class QCHParser 
{
	/**
	 * Constants
	 */
	static final String ARTISTA_PARAM 				= "artista=";
	static final String LLOC_PARAM 					= "lloc=";
	static final String CARREGALLOCS_PARAM 			= "carregaCalLlocs";
	static final String DOCUMENTS_PARAM				= "doc";
	static final String REFRESH_URL_PARAM   		= "refreshurls";
	static final String CARGA_ARTISTAS_FROM_MONGO 	= "cargaArtistaDeMongo";
	
	static final Logger logger 		= Logger.getLogger(QCHParser.class);
	
	
	/**
	 * MAIN
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
    	
    	//Initzalització
        logger.info( "QCHParser: Iniciant" );
    	init ();
        logger.info( "QCHParser: Inicialitzat");
        logger.info( "QCHParser: Parametres");
        logger.info( Params.toStringParams() );
        logger.info( "QCHParser: Fi Parametres");
        logger.info("QCH Console:");
        String s = null;
        do {

        	Scanner scan = new Scanner(System.in);
        	s = scan.nextLine();
        	parametres(s);
        	scan.close();
        }
        while(!s.trim().equalsIgnoreCase("fi"));
          
        //PrettyTimeParser prettyTimeParser = new PrettyTimeParser();
        
        
        //prettyTimeParser.
        //List<Date> dates = prettyTimeParser.parse("on 27th may 2017 at 7:00 am");
        //System.out.println(dates);
        // Prints: "[Sun Dec 12 13:45:12 CET 2013]"
    }


	/**
     * Initzalització del parser
     */
	private static void init() {
        logger.info( "QCHParser: Localitats carregades TOTs,PV,CAT,IB"+
        		Arrays.toString(Localitats.loadLocalitatsFromMunicipiosFile( ))); 
        logger.info( "QCHParser: VIES : " +Localitats.loadTipusVies()); 
        logger.info( "QCHParser: LlocsQCH: " +Localitats.loadTipusVies());
        logger.info( "QCHParser: Artistes: " +Artistes.carregaArtistaFromMongo() );
        if (Params.DEBUG_ARTISTES_JPA) Artistes.artistesToString();
        //logger.info( "QCHParser: AltresOrigents carregades: " +Artistes.carregaArtistaFromMongo() );
        //logger.info( "QCHParser: AltresOrigents \"com\" carregades: " +AltresOrigents.carregaComplementComArtista() );
	}
	
	/**
	 * Gestio dels parametres
	 * 
	 * @param s
	 */
    private static void parametres(String s) {
		if ((s.indexOf(ARTISTA_PARAM)) > -1)
		{
			buscaArtistaAccio(s);
		}
		else if ((s.indexOf(LLOC_PARAM)) > -1)
		{
			/*llocStr = (s.substring(i+"lloc=".length(), s.length())).trim();
			ArtistaParsing lloc = Localitats.getLlocFromString(llocStr);
			if (lloc == null)
				System.out.println("No trobat");
			else
				System.out.println("Trobat:"+lloc.getNm());*/
		}
		else if ((s.indexOf(CARREGALLOCS_PARAM)) > -1)
		{
			GeneradorLlocsLocalitats.generarLlocs();
		}
		else if ((s.indexOf(REFRESH_URL_PARAM)) > -1)
		{
			//URLs d'artistes - comprovem si hi han canvis
			List <Artiste> artistes = new ArtistesMongoDto().getArtistes();
			
			
			for (Iterator<Artiste> iterator = artistes.iterator(); iterator.hasNext();) {
				Artiste artiste =  iterator.next();
				logger.info("Buscant Events en url:"+artiste.getUrl());
				Artistes.getEventsFromArtistaURL(artiste);
				
			}

			
				//Para cada artista bajamos el contenido
			
				// Si hay cambios contenido tratamos el contenido nuevo
			
				// Java diff
			
			
			//URLs de llocs - comprovem si hi han canvis
			
		}
		else if ((s.indexOf(CARGA_ARTISTAS_FROM_MONGO)) > -1)
		{
			new ArtistesMongoDto().getArtistes();
			
		}
		else if ((s.indexOf('?')) > -1)
		{
			System.out.println
			("********************** ACCIONS *************************************************");
			System.out.println("1.-"+ARTISTA_PARAM+"<nom a buscar>");
			System.out.println("\tEspecifica un artista per a que siga identificat.");
			System.out.println("2.-"+LLOC_PARAM);
			System.out.println("3.-"+CARREGALLOCS_PARAM);
			System.out.println("4.-"+DOCUMENTS_PARAM);
			System.out.println("5.-"+REFRESH_URL_PARAM);
			System.out.println("\tComprova si hi ha novetats en els urls.");
			System.out.println("6.-"+CARGA_ARTISTAS_FROM_MONGO);
			System.out.println
			("*********************************************************************************");
		}
		else if ((s.indexOf(DOCUMENTS_PARAM)) > -1)
		{
	        logger.info( "QCHParser: Boti parser Iniciant" );
	        /*BotiParser botiParser = new BotiParser(new DocumentBoti(nomFitxer));
	        List<Event> listaEventsBoti = botiParser.getEvents();
	        logger.info( "QCHParser: Events: "+listaEventsBoti.size() );
	        logger.info( "QCHParser: Events: "+listaEventsBoti);*/
	        logger.info( "QCHParser: Boti parser Finalitzant" );
		}
		else
		{
			System.out.println("No hi ha acció");
		}
	} 
    
    //Accions /////////////////////////////////////////////////////////////////////
    protected static void buscaArtistaAccio(String s)
    {
    	String artistaStr = null;
    	int i=s.indexOf(ARTISTA_PARAM);
		artistaStr = (s.substring(i+ARTISTA_PARAM.length(), s.length())).trim();
		Artiste artista = Artistes.getArtistaFromString(artistaStr);
		if (artista == null)
			logger.info("No trobat");
		else
			logger.info("Trobat:"+artista.getNom());
    }


}
