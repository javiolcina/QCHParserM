package es.jaolve.QCHParserM.MongoDB.DTO;

import java.util.List;

import org.mongodb.morphia.query.Query;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;

/**
 * Funcions d'artistes en la base de dades Mongo
 * 
 * @author jaolve
 *
 */
public class ArtistesMongoDto extends AbstractMongoDto{

	/**
	 * Constructor que crida a la superclasse
	 * 
	 */
	public ArtistesMongoDto() {
		super();
	}

	/**
	 * 
	 */
	public List<Artiste> getArtistes()
	{
		try {

			final Query<Artiste> query = datastore.createQuery(Artiste.class);
			final List<Artiste> artistes = query.asList();
			
			logger.debug("Artistes recuperats de Mongo:"+artistes.size());
			datastore.ensureIndexes();
			return artistes;

		} catch (Exception e) {
			logger.error("Problema getArtistes"+e.getMessage());
			return null;
		}
	}
	
	public void artistaToMongo(Artiste a)
	{
		try {
			datastore.save(a);
			datastore.ensureIndexes();
		} catch (Exception e) {
			System.out.println("Problema passant artiesta a Mongo");
			System.out.println("Exception:"+e);
		}
	}

	public void artistaToMongoExample()
	{
		try {
			
			datastore.ensureIndexes();
			
			final Artiste a = new Artiste("Boti");
			a.addAltreNom("Botifarra");
			a.addAltreNom("Pep Gimeno 'Botifarra'");
			a.addAltreNom("Pep 'Botifarra'");
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
			
		} catch (Exception e) {
			System.out.println("Problema passant artiestes a Mongo");
			System.out.println("Exception:"+e);
		}
	}

}
