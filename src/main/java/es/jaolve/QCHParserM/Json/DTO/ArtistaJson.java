package es.jaolve.QCHParserM.Json.DTO;

import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.cor.paraules.SintagmaUtils;

public class ArtistaJson {
	
	final static Logger logger = Logger.getLogger(ArtistaJson.class);
	
	//Propietats de la classe
	String nm = null;
	Vector <String> espectacles 	= null;
	Vector <String> altresnoms 		= null;


	/**
	 * Constructor
	 * 
	 * @param nm
	 * @param espectacles
	 */
	public ArtistaJson(String nm, Vector<String> espectacles,Vector<String> altresnoms) {
		super();
		this.nm 			= nm;
		this.espectacles 	= espectacles;
		this.altresnoms 	= altresnoms;
		
	}


	public String getNm() {
		return nm;
	}


	public void setNm(String nm) {
		this.nm = nm;
	}


	public Vector<String> getEspectacles() {
		return espectacles;
	}


	public void setEspectacles(Vector<String> espectacles) {
		this.espectacles = espectacles;
	}
	
	public Vector<String> getAltresnoms() {
		return altresnoms;
	}


	public void setAltresnoms(Vector<String> altresnoms) {
		this.altresnoms = altresnoms;
	}
	
	/**
	 * Implementa els mecanismes per a intentar identificar un artista amb un String:
	 * Se consulta el nom i altres noms
	 * - Nom igual al oficial o
	 * - ( >75% de coincidencies
	 * - Totes les paraules menys y totes menys una comú)
	 * 
	 * @param artistaStr
	 * @return 
	 */
	public boolean isArtistaNom(String artistaStr) {
		boolean resultat = false;
		resultat =  (nm.equalsIgnoreCase(artistaStr)
				|| SintagmaUtils.sintagmesIguals(nm, artistaStr, 75, 1));
		
		//Altres noms
		if (!resultat && altresnoms != null)
		{
			Iterator<String> i = altresnoms.iterator();
			while (!resultat && i.hasNext()) {
				resultat = SintagmaUtils.sintagmesIguals(i.next(), artistaStr, 75, 1) ;
			}
		}
		
		return resultat;
	}
	
	/**
	 * Implementa els mecanismes per a intentar identificar el nom d'un 
	 * espectacle en el text:
	 * Se consulta el nom i altres noms
	 * - Nom igual al oficial o
	 * - ( >75% de coincidencies
	 * - Totes les paraules menys y totes menys una comú)
	 * 
	 * @param artistaStr
	 * @return 
	 */
	public boolean teEspectable(String text) {
		boolean resultat = false;
		resultat =  (nm.equalsIgnoreCase(text)
				|| SintagmaUtils.sintagmesIguals(nm, text, 75, 1));
		
		//Altres noms
		if (!resultat && altresnoms != null)
		{
			Iterator<String> i = altresnoms.iterator();
			while (!resultat && i.hasNext()) {
				resultat = SintagmaUtils.sintagmesIguals(i.next(), text, 75, 1) ;
			}
		}
		
		return resultat;
	}
}
