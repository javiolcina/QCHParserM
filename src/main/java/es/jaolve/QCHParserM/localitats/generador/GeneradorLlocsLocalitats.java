package es.jaolve.QCHParserM.localitats.generador;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;
import es.jaolve.QCHParserM.cor.localitats.Localitats;
import es.jaolve.QCHParserM.input.Fitxers;

public class GeneradorLlocsLocalitats {

	final static Logger logger 		= Logger.getLogger(GeneradorLlocsLocalitats.class);
	
	public static void generarLlocs() 
	{
		//llegir fitxer
		try
		{
			FileInputStream fstream = new FileInputStream(Fitxers.LOCATIONS_FILE);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int troballes = 0;
			int linies = 0;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   
			{
				//buscar Localitat
				Localitat localitat = Localitats.teLocalitat (strLine);
				if (localitat != null)
				{
					logger.debug(localitat.getNom()+" --- "+strLine);
					Localitats.addLlocToLocalitat(localitat.getId(),strLine);
					troballes ++;
				}
				else
					logger.debug("No trobat --- "+strLine);
				// Completar lloc
				linies ++;
			}
			logger.debug("Trobades LlocsQCH en localitat:"+troballes+"/"+linies);	
			//Close the input stream
			in.close();
			
			//Enviar-ho tot a un Json
			Gson gson = new Gson();
            Type type = new TypeToken<List<Localitat>>() {}.getType();
            String json = gson.toJson(Localitats.localitatsPV, type);
            System.out.println(json);
			
			
		}catch (Exception e){
			logger.error("Error: " + e.getMessage());
		}

	}

}
