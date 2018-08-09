package es.jaolve.QCHParserM.localitats;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.Fitxers;

public class Llocs {

	final static Logger logger 		= Logger.getLogger(Llocs.class);
	
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
			System.err.println("Error: " + e.getMessage());
			return llocs;
		}

	}

}
