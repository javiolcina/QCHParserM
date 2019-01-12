package es.jaolve.QCHParserM.document;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.Params;

public class DocumentUtils {
	
	
	final static Logger logger = Logger.getLogger(DocumentUtils.class);
	
	/**
	 * Torna llista de seccions separades per marques de Separació
	 * 
	 * @param marcaSeparacio
	 * @param document
	 * @return
	 */
	public static List<String> getSeccions(String marcaSeparacio, String document)
	{
		int indice1 = 0;
		int indice2 = 0;
		Vector<String> seccions = new Vector<String>();
		int seccio = 1;
		
		logger.info( "QCHParser: getSeccions: " );
		while (document.length() > indice1)
		{
			indice2 = document.indexOf(marcaSeparacio, indice1);
			if (indice2 == -1)
				indice2 = document.length();
			
			//Secció massa xicoteta
			if (indice2-indice1<Params.DOCUMENT_SECCIO_MINIMA)
			{
				if (Params.DEBUG_SECCIONS) logger.debug("Seccio decartada :("+indice1+"-"+indice2+")="+document.substring(indice1, indice2));
			}
			else
			{
				seccions.add(document.substring(indice1, indice2));
				if (Params.DEBUG_SECCIONS) logger.debug("Seccio"+seccio+":("+indice1+"-"+indice2+")="+document.substring(indice1, indice2));
				seccio ++;
			}
			indice1 = indice2 + marcaSeparacio.length();
			
		}
		
		return seccions;
	}
}
