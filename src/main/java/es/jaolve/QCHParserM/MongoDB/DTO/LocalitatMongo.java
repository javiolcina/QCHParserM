package es.jaolve.QCHParserM.MongoDB.DTO;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.w3c.dom.views.AbstractView;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;
import es.jaolve.QCHParserM.input.localitats.LlocsQCH;

/**
 * Funcions d'artistes en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class LocalitatMongo extends AbstractMongoDto {
	
	final static Logger logger 		= Logger.getLogger(LocalitatMongo.class);


	public List <Localitat> getLocalitats()
	{
		List<es.jaolve.QCHParserM.MongoDB.JPA.Localitat> localitatsResulta = new Vector<es.jaolve.QCHParserM.MongoDB.JPA.Localitat>();
		
		try {

			final Query<es.jaolve.QCHParserM.MongoDB.JPA.Localitat> query = datastore.createQuery(es.jaolve.QCHParserM.MongoDB.JPA.Localitat.class);
			localitatsResulta = query.asList();
			
			logger.debug("Localitats:"+localitatsResulta.size());
			
		} catch (Exception e) {
			logger.debug("Problema obtenint localitats");
			logger.debug("Exception:"+e);
		}
		return localitatsResulta;
	}
	
	public void localitatToMongo(Localitat l)
	{
		try {
			datastore.ensureIndexes();
			datastore.save(l);
			
		} catch (Exception e) {
			System.out.println("Problema insertant localitats");
			System.out.println("Exception:"+e);
		}
	}
	
	public void localitatToMongoExample()
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
