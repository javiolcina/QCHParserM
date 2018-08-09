package es.jaolve.QCHParserM.cor.artistes;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.paraules.SintagmaUtils;


/**
 * Funcions de parsing per a treballar amb artista
 * 
 * @author jaolve
 *
 */
public class ArtistaParsing {
	
	final static Logger logger = Logger.getLogger(ArtistaParsing.class);

	
	/**
	 * 
	 * Implementa els mecanismes per a intentar identificar un artista amb un String:
	 * Se consulta el nom i altres noms
	 * - Nom igual al oficial o
	 * - ( >75% de coincidencies
	 * - Totes les paraules menys y totes menys una comú)
	 * 
	 * @param artiste
	 * @param artistaStr
	 * @return
	 */
	public static boolean isArtistaNom(Artiste artiste, String artistaStr) {
		boolean resultat = false;
		String nm = artiste.getNom();
		resultat =  (nm.equalsIgnoreCase(artistaStr)
				|| SintagmaUtils.sintagmesIguals(nm, artistaStr, 75, 1));
		
		//Altres noms
		if (!resultat && artiste.getAltresNoms() != null)
		{
			Iterator<String> i = artiste.getAltresNoms().iterator();
			while (!resultat && i.hasNext()) {
				String altreNom = i.next();
				resultat = SintagmaUtils.sintagmesIguals(altreNom, artistaStr, 75, 1) ;
			}
		}
		
		return resultat;
	}
	
	/**
	 * Torna un espectacle d'un artista si se troba a partir d'un string
	 * Torna 
	 * 
	 * @param artiste
	 * @param artistaStr
	 * @return
	 */
	public static String getArtistaEspectacle(Artiste artiste, String spectacleStr) {
		boolean espectacleTrobat 	= false;
		String resultat 			= null;
		String espectacle			= null;
		//Espectacles
		Iterator<String> i = artiste.getEspectacles().iterator();
		while (!espectacleTrobat && i.hasNext()) 
		{
			espectacle = i.next();
			//TODO: Cal reimplementar aquest punt
			 if (SintagmaUtils.sintagmesIguals(espectacle, spectacleStr, 75, 1))
			 {
				 espectacleTrobat = true;
				 resultat = espectacle;
			 }
			 	
		}
		
		return resultat;
	}
	
	/**
	 * 
	 * Implementa els mecanismes per a intentar identificar el nom d'un 
	 * espectacle en el text:
	 * Se consulta el nom i altres noms
	 * - Nom igual al oficial o
	 * - ( >75% de coincidencies
	 * - Totes les paraules menys y totes menys una comú)
	 * 
	 * @param artiste
	 * @param text
	 * @return
	 */
	public static boolean teEspectable(Artiste artiste, String text) {
		boolean resultat = false;
		String nm = artiste.getNom();
		resultat =  (nm.equalsIgnoreCase(text)
				|| SintagmaUtils.sintagmesIguals(nm, text, 75, 1));
		
		//Altres noms
		if (!resultat && artiste.getAltresNoms() != null)
		{
			Iterator<String> i = artiste.getAltresNoms().iterator();
			while (!resultat && i.hasNext()) {
				resultat = SintagmaUtils.sintagmesIguals(i.next(), text, 75, 1) ;
			}
		}
		
		return resultat;
	}
}
