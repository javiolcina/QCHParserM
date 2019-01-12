package es.jaolve.QCHParserM.cor.localitats;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.cor.paraules.SintagmaUtils;
import es.jaolve.QCHParserM.input.Fitxers;

/**
 * Funcions d'ultilitat de Localitats
 * 
 * @author jaolve
 *
 */
public class LocalitatsUtils {

	final static Logger logger = Logger.getLogger(SintagmaUtils.class);
 
	public static String filtraCarrer(String nomLocalitat)
	{
		StringTokenizer st = new StringTokenizer(nomLocalitat);
		String resultado = "";
		String token = st.nextToken(" ");
	    if  (st.hasMoreTokens()) {
	         resultado = st.nextToken() +" " + resultado;
	     }
	    
	    return resultado;
	}
	
	
	/**
	 * Carrega vies des de fitxer
	 * 
	 * @return
	 */
	public static Vector<String> carregarTipusVies()
	{
		Vector<String> vies = new Vector<String>();
		try
		{
			FileInputStream fstream = new FileInputStream(Fitxers.VIES_FILE);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int troballes = 0;
			int linies = 0;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				vies.add(strLine);
			}
			return vies ;
		}catch (Exception e) {
			logger.error("Problema carregant fitxer Tipus de vies:"+Fitxers.VIES_FILE);
			return vies;
		}

	}
	
	
	/**
	 * Formata el text llevant la coma de l'article
	 * 
	 * @param nomLocalitat
	 * @return
	 */
	public static String rotaComa(String nomLocalitat)
	{
		StringTokenizer st = new StringTokenizer(nomLocalitat);
		String resultado = st.nextToken(",");
	    if  (st.hasMoreTokens()) {
	         resultado = st.nextToken() +" " + resultado;
	     }
	    
	    return resultado;
	}
	
}
