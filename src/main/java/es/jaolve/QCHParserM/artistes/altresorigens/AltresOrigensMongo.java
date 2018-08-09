package es.jaolve.QCHParserM.artistes.altresorigens;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.MongoDB.JPA.Garito;

/**
 * Funcions d'altres orgients (webs, events musicals) en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class AltresOrigensMongo {


	/**
	 * 
	 */
	public static void getAltresOrigens()
	{
		try {
			//Creem client
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
			DB database = mongoClient.getDB("QCH");
			
			final Morphia morphia = new Morphia();

			// tell Morphia where to find your classes
			// can be called multiple times with different packages or classes
			 morphia.mapPackage("es.jaolve.QCHParserM.MongoDB");

			// create the Datastore connecting to the default port on the local host
			final Datastore datastore = morphia.createDatastore(mongoClient, "QCH");

			final Query<Garito> query = datastore.createQuery(Garito.class);
			final List<Garito> altresOrigens = query.asList();
			
			System.out.println("AltresOrigents:"+altresOrigens.size());
			
			datastore.ensureIndexes();
			//Matem el client
			mongoClient.close();
		} catch (Exception e) {
			System.out.println("Problema localitzant host");
			System.out.println("Exception:"+e);
		}
		
	}
	
	/**
	 * 
	 */
	public static void altresOrigensMongoToMongo()
	{
		try {
			//Creem client
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
			DB database = mongoClient.getDB("QCH");
			
			final Morphia morphia = new Morphia();

			// tell Morphia where to find your classes
			// can be called multiple times with different packages or classes
			 morphia.mapPackage("es.jaolve.QCHParserM.MongoDB");

			// create the Datastore connecting to the default port on the local host
			final Datastore datastore = morphia.createDatastore(mongoClient, "QCH");
			datastore.ensureIndexes();
			
			final Artiste a = new Artiste("Boti");
			a.addAltreNom("Botifarra");
			a.addAltreNom("Pep Gimeno 'Botifarra'");
			a.addEspectable("Botifarra a duo");
			a.addEspectable("Botifarra a banda");
			a.addEspectable("Botifarra i la rondalla");
			a.addEspectable("Ja ve Nadal");
			datastore.save(a);
			
			final Artiste a1 = new Artiste("Tres Fan Ball");
			datastore.save(a1);
			
			final Artiste a2 = new Artiste("Urbàlia Rurana");
			a2.setUrl("http://www.urbaliarurana.com/PAGES/Agenda.htm");
			a2.addEspectable("De tornada a les ribes");
			a2.addEspectable("Sarau a la Plaça");
			datastore.save(a2);
			
			//Matem el client
			mongoClient.close();
		} catch (Exception e) {
			System.out.println("Problema localitzant host");
			System.out.println("Exception:"+e);
		}
	}

}
