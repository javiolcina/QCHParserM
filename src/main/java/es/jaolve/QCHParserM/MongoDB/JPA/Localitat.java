package es.jaolve.QCHParserM.MongoDB.JPA;

import java.util.Vector;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Representa una entitat JPA per a Mongo
 * 
 * @author jaolve
 *
 */

@Entity("Localitat")
public class Localitat {
	
	@Id
	private String id 	= null;
	//Propietats
	private String nom 	= null;
	//Altres noms per els que es coneix la localitat
	private Vector<String> sinonims = null;
	//Llocs concrets dins de la localitat
	private Vector<String> llocs = null;
	//Numero de coincidencies per a evaluar el pes del Municipi
	private int numCoincidencias = 0;
	
	public Localitat(String id, String nom) {
		super();
		this.id 	= id;
		this.nom 	= nom;
		llocs 		= new Vector();
		sinonims 	= new Vector();
	}
	public String getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public Vector<String> getSinonims() {
		return sinonims;
	}
	public void addSinonim(String sinonim) {
		this.sinonims.add(sinonim);
	}
	public Vector<String> getLlocs() {
		return llocs;
	}
	public void addLlocs( String  lloc) {
		this.llocs.add(lloc);
	}


	
	

}
