package es.jaolve.QCHParserM.MongoDB.JPA;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * Representa una entitat JPA per a Mongo
 * Festival 
 * 
 * @author jaolve
 *
 */
@Entity("Festival")
public class Festival {
	
	@Id
	private String nom;
	private String url;
	private List<String> direccionConcreta = new ArrayList<String>();
	private String direccioComu;
	

	/**
	 * Contructor
	 * 
	 */
	public Festival()
	{
		this.nom 			= "";
		this.url 			= "";
		this.direccioComu = "";
	}
	
	/**
	 * Constructor
	 * 
	 * @param nom
	 */
	public Festival(String nom, String url)
	{
		this.nom 			= nom;
		this.url 			= "";
	}

	public List<String> getDireccionConcreta() {
		return direccionConcreta;
	}

	public void addDireccionConcreta(String direccionConcreta) {
		this.direccionConcreta.add(direccionConcreta);
	}

	public String getDireccioComu() {
		return direccioComu;
	}

	public void setDireccioComu(String direccioComu) {
		this.direccioComu = direccioComu;
	}

	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}
	
	

	
}
