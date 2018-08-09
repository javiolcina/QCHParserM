package es.jaolve.QCHParserM.MongoDB;

import java.net.UnknownHostException;
import java.util.Iterator;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCursorNotFoundException;
/**
 * Classe de prova basada en http://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/
 * 
 * 
 * @author jaolve
 *
 */
public class ConectMongoDB {

	public static void main(String[] args) {
		
		try {
			//Creem client
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
			DB database = mongoClient.getDB("QCH");
			System.out.println("BD:"+database.getName());
			
			DBCollection collection = database.getCollection("urls");
			System.out.println("Collection:" + collection.getFullName() + " " + collection.getCount() );
			
			DBCursor urlsCursor =  collection.find();
			//System.out.println("URL:" + urlsCursor.one().get("url"));
			
			Iterator<DBObject> i = urlsCursor.iterator();

		    while (i.hasNext()) {
		        System.out.println(i.next().get("url"));
		    }

			//Tanquem el client
			mongoClient.close();
		} catch (Exception e) {
			System.out.println("Problema localitzant host");
		}
		
	}

}
