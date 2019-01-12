package es.jaolve.QCHParserM.cor.paraules;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import es.jaolve.QCHParserM.Params;

/**
 * Utilitats a nivell de paraula
 * 
 * @author jaolve
 *
 */
public class TextUtils {
	
	public static final String split_mask = "[^a-zA-Z\"]+";
	
	/**
	 * Canvi accent, la lletra a canviar ha d'estar marcada entre []
	 * a->à->á
	 * e->é->è
	 * i<->í
	 * o<->ó
	 * ú<->u
	 * @param text
	 * @return Vector de paraules amb accent rotant seguinr
	 */
	@SuppressWarnings("serial")
	public static Vector<String> rotarAccents(String paraula)
	{
		String sustituible = null;
		Vector<String> paraules = new Vector<String>();
		Set<String> as = new HashSet<String>() {{add("a");add("á");add("à");}};
		Set<String> es = new HashSet<String>() {{add("e");add("è");add("é");}};
		Set<String> is = new HashSet<String>() {{add("i");add("í");}};
		Set<String> os = new HashSet<String>() {{add("o");add("ó");}};
		Set<String> us = new HashSet<String>() {{add("u");add("ú");}};
		
		int i1 = paraula.indexOf("[");
		if ( i1>-1 && i1+2 == paraula.indexOf("]") )
			sustituible = new String(paraula.charAt(i1+1)+"").trim();
		
		Set<String> xs = null;
		if (sustituible!=null)
		{
			if (as.contains(sustituible))
				xs = as;
			if  (es.contains(sustituible))
				xs = es;
			if (is.contains(sustituible))
				xs = is;
			if (os.contains(sustituible))
				xs = os;
			if (us.contains(sustituible))
				xs = us;
		
			for (String s : xs) {
				
		        paraules.add(paraula.substring(0, i1)+
		        			s +
		        			paraula.substring(i1+3, paraula.length()));
		    }
		}
		
		return paraules;
	}
 
	/**
	 * Common Words (v3.21)
     * by  Harry (2013/Sep)
     * mod GoToLoop
     * 
     * http://forum.processing.org/topic/
     * how-can-i-calculate-similarity-score-of-strings
	 * 
	 * @param x
	 * @param y
	 * @return paraules que coincideixen
	 */
    public static final String[] commonWords(String x, String y) 
    {
      final String[] xWords = x.toLowerCase().split(split_mask);
      final String[] yWords = y.toLowerCase().split(split_mask);

      HashSet<String> xSet = new HashSet<String>(Arrays.asList(xWords));
      HashSet<String> ySet = new HashSet<String>(Arrays.asList(yWords)); 
      
      xSet = filtraHashSetDeParaulesCurtes(xSet,Params.commonWords_minimaLongitud);
      ySet = filtraHashSetDeParaulesCurtes(ySet,Params.commonWords_minimaLongitud);
      
      xSet.retainAll( ySet);

      return xSet.toArray( new String[xSet.size()] );
    }
    
    /**
     * Percentatge de coincidència
     * 
     * @param s0
     * @param s1
     * @return
     */
	public static int pecentageOfTextMatch(String s0, String s1) 
	{                       // Trim and remove duplicate spaces
	    int percentage = 0;
	    s0 = s0.trim().replaceAll("\\s+", " ");
	    s1 = s1.trim().replaceAll("\\s+", " ");
	    percentage=(int) (100 - (float) LevenshteinDistance(s0, s1) * 100 / (float) (s0.length() + s1.length()));
	    return percentage;
	}
	
	/**
	 * Distància Levenshtein
	 * 
	 * @param s0
	 * @param s1
	 * @return
	 */
	private static int LevenshteinDistance(String s0, String s1) {
	
	    int len0 = s0.length() + 1;
	    int len1 = s1.length() + 1;  
	    // the array of distances
	    int[] cost = new int[len0];
	    int[] newcost = new int[len0];
	
	    // initial cost of skipping prefix in String s0
	    for (int i = 0; i < len0; i++)
	        cost[i] = i;
	
	    // dynamically computing the array of distances
	
	    // transformation cost for each letter in s1
	    for (int j = 1; j < len1; j++) {
	
	        // initial cost of skipping prefix in String s1
	        newcost[0] = j - 1;
	
	        // transformation cost for each letter in s0
	        for (int i = 1; i < len0; i++) {
	
	            // matching current letters in both strings
	            int match = (s0.charAt(i - 1) == s1.charAt(j - 1)) ? 0 : 1;
	
	            // computing cost for each transformation
	            int cost_replace = cost[i - 1] + match;
	            int cost_insert = cost[i] + 1;
	            int cost_delete = newcost[i - 1] + 1;
	
	            // keep minimum cost
	            newcost[i] = Math.min(Math.min(cost_insert, cost_delete),
	                    cost_replace);
	        }
	
	        // swap cost/newcost arrays
	        int[] swap = cost;
	        cost = newcost;
	        newcost = swap;
	    }
	
	    // the distance is the cost for transforming all letters in both strings
	    return cost[len0 - 1];
	}
	
	/**
	 * Filtra un hashset de Strings eliminants els que son menos de la longitud de parametros
	 * 
	 * @return
	 */
	public static HashSet<String> filtraHashSetDeParaulesCurtes(HashSet<String> in, int minimaLongitud)
	{
		HashSet<String> out = new HashSet<String>();
		for (Iterator<String> iterator = in.iterator(); iterator.hasNext();) {
			String paraula = (String) iterator.next();
			if (!(paraula.length() < minimaLongitud))
				out.add(paraula);
		}
		return out;
	}

	/**
	 * Torna la longitud dels strings
	 * 
	 * @return
	 */
	public static int getLongitud(String[] in)
	{
		int longitud = 0;
		for (int i = 0; i < in.length; i++) {
			longitud = longitud + in[i].length();
		}
		
		return longitud;
	}
}
