package es.jaolve.QCHParserM.cor.paraules;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

import org.apache.log4j.Logger;

public class SintagmaUtils {
	
	final static Logger logger = Logger.getLogger(SintagmaUtils.class);

	/**
	 * Genera per a la lletra marcada la seua correspondència en accent
	 * 
	 * @param text
	 * @return torna totes les possibilitats
	 */
	public static Vector<String> generarAccents(String text)
	{
		return null;
	}
	
	/**
	 * Evalua si dos sintagmes són raonablement iguals
	 * 
	 * @param paraula1
	 * @param paraula2
	 * @param percentatge
	 * @param diferenciaParaules
	 * @return
	 */
	public static boolean sintagmesIguals(String original,String acomparar, 
											int percentatge, int diferenciaParaules)
	{
		int percentatgeX 	= TextUtils.pecentageOfTextMatch(original, acomparar);
		String[] pc  = TextUtils.commonWords(original, acomparar);
		int longitudParaulesComunes = TextUtils.getLongitud(pc);
		int paraulesComuns 	= pc.length;
		
		float percentatgeComu = 0;
		if (longitudParaulesComunes > 0)
			percentatgeComu = (original.length()/longitudParaulesComunes);
		
		int paraulesOrigen	= original.split(TextUtils.split_mask).length;
		boolean condicion	= 
							// Si es igual per %
							percentatgeX > percentatge   ||
							// Si te totes les paraules igual menys diferencia i te mes dos paraula
							(paraulesComuns >= paraulesOrigen - diferenciaParaules && paraulesComuns > 0) ||
							// Alguna paraula comu i longitud de les paraules comuns suposa un 75%
							(paraulesComuns > 0 && percentatgeComu > 0.75)
							;
		
		logger.debug(original+":"+acomparar+" "+
				percentatgeX+"% "+paraulesComuns+"("+condicion+")"+
				"l "+percentatgeComu);
		return 
				condicion;
	}
}
