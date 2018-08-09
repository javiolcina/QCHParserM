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
import es.jaolve.QCHParserM.MongoDB.JPA.Garito;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;

/**
 * Funcions de garitos en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class GaritosMongo extends AbstractMongoDto {


	/**
	 * 
	 */
	public void getGaritos()
	{
		try {

			final Query<Garito> query = datastore.createQuery(Garito.class);
			final List<Garito> garitos = query.asList();
			
			System.out.println("Garitos:"+garitos.size());
			
		} catch (Exception e) {
			System.out.println("Problema obtenint Garitos");
			System.out.println("Exception:"+e);
		}
		
	}
	
	/**
	 * 
	 */
	public void garitoToMongo()
	{
		try {

			datastore.ensureIndexes();
			
			final Garito g = new Garito("La Caverna");
			g.setDireccioLlarga("carrer Cuenca");
			datastore.save(g);
 
		} catch (Exception e) {
			System.out.println("Problema insertant garitos");
			System.out.println("Exception:"+e);
		}
	}

}
