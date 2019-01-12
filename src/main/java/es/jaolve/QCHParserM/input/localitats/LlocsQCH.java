package es.jaolve.QCHParserM.input.localitats;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.input.Fitxers;

public class LlocsQCH {

	final static Logger logger 		= Logger.getLogger(LlocsQCH.class);
	
	/**
	 * Carrega llocs
	 */
	public static Vector<String> loadLlocs()
	{
		Vector<String> llocs = new Vector<String>();
		
		//llegir fitxer
		try
		{
			FileInputStream fstream = new FileInputStream(Fitxers.LOCATIONSTOT_FILE);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   
			{
				llocs.add(strLine);
			}
			
			//Close the input stream
			in.close();
			
			return llocs;
			
		}catch (Exception e){
			logger.error("Error: " + e.getMessage());
			return llocs;
		}

	}

}
