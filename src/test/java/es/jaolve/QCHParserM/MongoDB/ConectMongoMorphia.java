package es.jaolve.QCHParserM.MongoDB;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import es.jaolve.QCHParserM.MongoDB.JPA.url;

public class ConectMongoMorphia {

	public static void main(String[] args) {
		
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
			
			//final Employee elmer = new Employee("Elmer Fudd", 50000.0);
			//datastore.save(elmer);
			
			
			final Query<url> query = datastore.createQuery(url.class);
			final List<url> urls = query.asList();
			System.out.println("urls recuperadas:"+urls.size());
			
			url url1 = new url();
			url1.setNom("Noom");
			url1.setUrl("https://kk.com");
			
			Key<url> savedUrl = datastore.save(url1); 
			
			
			System.out.println("BD:"+database.getName());
			
			/*DBCollection collection = database.getCollection("urls");
			System.out.println("Collection:" + collection.getFullName() + " " + collection.getCount() );
			
			DBCursor urlsCursor =  collection.find();
			System.out.println("URL:" + ((url)urls.get(0)));*/
			
			
			
			//Matem el client
			mongoClient.close();
		} catch (Exception e) {
			System.out.println("Problema localitzant host");
			System.out.println("Exception:"+e);
		}
		
	}

}
