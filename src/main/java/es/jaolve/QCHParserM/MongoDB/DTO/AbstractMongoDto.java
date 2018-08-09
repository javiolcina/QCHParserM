package es.jaolve.QCHParserM.MongoDB.DTO;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import es.jaolve.QCHParserM.QCHParser;

/**
 * Classe que han d'implementar els DTOs
 * 
 * @author jaolve
 *
 */
public abstract class AbstractMongoDto {
	
	Datastore datastore 	= null;
	MongoClient mongoClient = null;
	
	final static Logger logger 		= Logger.getLogger(AbstractMongoDto.class);
	
	/**
	 * Constructor
	 */
	public AbstractMongoDto()
	{
		conectar();
	}
	
	/**
	 * Conecta a una base de dades Mongo
	 * 
	 */
	public void conectar()
	{
		try
		{
			//Creem client
			mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
			DB database = mongoClient.getDB("QCH");
			
			final Morphia morphia = new Morphia();

			// tell Morphia where to find your classes
			// can be called multiple times with different packages or classes
			 morphia.mapPackage("es.jaolve.QCHParserM.MongoDB.JPA");

			// create the Datastore connecting to the default port on the local host
			datastore = morphia.createDatastore(mongoClient, "QCH");
		}
		catch (Exception e) {
			System.out.println("Problema localitzant host");
			System.out.println("Exception:"+e);
		}
		
	}
	
	/**
	 * Desconecta a una base de dades Mongo
	 * 
	 */
	public void desconectar()
	{
		try
		{
			//Matem el client
			mongoClient.close();
		}
		catch (Exception e) {
			System.out.println("Problema desconectant");
			System.out.println("Exception:"+e);
		}

		
	}

}
