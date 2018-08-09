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
import es.jaolve.QCHParserM.MongoDB.JPA.Festival;
import es.jaolve.QCHParserM.MongoDB.JPA.Garito;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;

/**
 * Funcions de festiales en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class FestivalesMongo extends AbstractMongoDto {


	/**
	 * 
	 */
	public void getFestivals()
	{
		try {

			final Query<Festival> query = datastore.createQuery(Festival.class);
			final List<Festival> festival = query.asList();
			
			System.out.println("Festivals:"+festival.size());
			
		} catch (Exception e) {
			System.out.println("Problema obtenint Festivals");
			System.out.println("Exception:"+e);
		}
		
	}
	
	/**
	 * 
	 */
	public void festivalToMongo()
	{
		try {

			datastore.ensureIndexes();
			
			final Festival f = new Festival("Festhivern","www.festivern.es");
			f.setDireccioComu("Tavernes");
			datastore.save(f);
 
		} catch (Exception e) {
			System.out.println("Problema insertant festival");
			System.out.println("Exception:"+e);
		}
	}

}
