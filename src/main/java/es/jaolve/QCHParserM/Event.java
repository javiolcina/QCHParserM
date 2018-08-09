package es.jaolve.QCHParserM;

import java.util.Date;

/**
 * Representació d'un event Google Calendar procedent del parser
 * 
 * @author jaolve
 *
 */
public class Event {

	String titol 		= "";
	String artista		= "";
	String espectacle	= "";
	String descripcio 	= "";
	String on			= "";
	Date   ini			= null;
	Date   fin			= null;

	/**
	 * Constructor amb espectacle
	 * 
	 * @param titol
	 * @param artista
	 * @param espectacle
	 * @param descripcio
	 * @param on
	 * @param ini
	 * @param fin
	 */
	public Event(String titol, String artista, String espectacle, 
			String descripcio, String on, Date ini, Date fin) {
		new Event(titol, artista, descripcio, on, ini, fin);
		
		this.espectacle 		= espectacle;
	}
	
	/**
	 * Constructor
	 * 
	 * @param titol
	 * @param artista
	 * @param descripció
	 * @param on
	 * @param ini
	 * @param fin
	 */
	public Event(String titol, String artista, String descripcio, String on, Date ini, Date fin) {
		super();
		if (titol != null)
			this.titol 		= titol;
		else
			this.titol 		= artista + "." + on;
			
		this.artista 	= artista;
		this.descripcio = descripcio;
		this.on 		= on;
		this.ini 		= ini;
		this.fin 		= fin;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\n\t [titol:"+titol+" \n");
		stringBuffer.append("\t artista:"+artista+" \n");
		stringBuffer.append("\t espectacle:"+espectacle+" \n");
		stringBuffer.append("\t descripció:"+descripcio+" \n");
		stringBuffer.append("\t on:"+on+" \n");
		stringBuffer.append("\t ini:"+ini+"fin"+fin+"] \n\n");
		return stringBuffer.toString();
	}
	
	
}
