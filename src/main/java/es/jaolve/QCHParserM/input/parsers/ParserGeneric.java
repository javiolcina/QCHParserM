package es.jaolve.QCHParserM.input.parsers;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;
import es.jaolve.QCHParserM.cor.artistes.Artistes;
import es.jaolve.QCHParserM.cor.localitats.Localitats;
import es.jaolve.QCHParserM.input.document.DocumentAbstract;
import es.jaolve.QCHParserM.output.event.Event;

/**
 * Parser genèric
 * 
 * @author jaolve
 *
 */
public class ParserGeneric {
	//protected String nomParser 			= "";
	protected DocumentAbstract document		= null;
	protected String nomParser 				= null;
	
	final static Logger logger = Logger.getLogger(ParserGeneric.class);
	
	/**
	 * Constructor
	 * 
	 */
	public ParserGeneric()
	{}
	
	/**
	 * Constructor 
	 * @param nomParser fitxer local
	 * @param documentAbstract
	 */
	public void setDocument(DocumentAbstract documentAbstract) {
		this.document 			= documentAbstract;
	}

	public void setNomParser(String nomParser) {
		this.nomParser 			= nomParser;
		}
	
	/**
	 * Torna els events que troba en una secció  
	 * 
	 * @param artiste del event, si ve especificat
	 * @return
	 */
	public List<Event> getEvents(Artiste artiste) {
		List<Event> events = new Vector<Event>();
		
		logger.info( "QCHParser: getEvents: " );
		List<String> seccions = document.getSeccions();
		
		//recorreguem les seccions per a fer-les events
		for (String seccio : seccions) {
			events.add(getEvent(seccio,artiste));
		}
		
		return events;
	}
	
	
	//Métodes abstractes //////////////////////////////////////////////////////
	/**
	 * Trau un Event d'una secció
	 * 
	 * @param seccio
	 * @param artista sabut
	 * @return
	 */
	protected Event getEvent(String seccio,Artiste artista)
	{
		String nomArtista = null;
		if (artista != null)
			nomArtista = artista.getNom();
		else
			nomArtista = getArtista(seccio);
		
		Event nouEvent  = new Event(Artistes.getEspectaclePerArtistaFromString(artista, seccio),
				nomArtista,seccio, getLloc(seccio) , new Date(), new Date() );
		return nouEvent;
	}

	/**
	 * Intenta buscar un artista, de moment, a la secció
	 * 
	 * 
	 * @return
	 */
	private String getArtista(String seccio) 
	{
		String artista = "";
		if (document.getArtistaPerDefecte() != null)
			artista = document.getArtistaPerDefecte();
		else 
			logger.warn("No hay artista por defecto");
		
		//TODO: búsqueda de complements
		
		return artista;
	}
	
	/**
	 * Intenta buscar un lloc a la secció
	 * 
	 * 
	 * @return
	 */
	private String getLloc(String seccio) 
	{
		String lloc = "";
		Localitat l = Localitats.teLocalitat(seccio);
		if (l != null)
			lloc = l.getNom();
		return lloc;
	}


}
