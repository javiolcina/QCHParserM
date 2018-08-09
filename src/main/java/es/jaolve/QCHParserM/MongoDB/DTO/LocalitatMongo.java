package es.jaolve.QCHParserM.MongoDB.DTO;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.w3c.dom.views.AbstractView;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;

/**
 * Funcions d'artistes en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class LocalitatMongo extends AbstractMongoDto {


	/**
	 * 
	 */
	public void getLocalitats()
	{
		try {

			final Query<es.jaolve.QCHParserM.MongoDB.JPA.Localitat> query = datastore.createQuery(es.jaolve.QCHParserM.MongoDB.JPA.Localitat.class);
			final List<es.jaolve.QCHParserM.MongoDB.JPA.Localitat> artistes = query.asList();
			
			System.out.println("Localitats:"+artistes.size());
			
		} catch (Exception e) {
			System.out.println("Problema obtenint localitats");
			System.out.println("Exception:"+e);
		}
		
	}
	
	/**
	 * 
	 */
	public void localitatToMongo()
	{
		try {

			datastore.ensureIndexes();
			
			final Localitat l = new Localitat("València", "València");
			l.addLlocs("Plaça Ajuntament");
			datastore.save(l);
 
		} catch (Exception e) {
			System.out.println("Problema insertant localitats");
			System.out.println("Exception:"+e);
		}
	}

}
