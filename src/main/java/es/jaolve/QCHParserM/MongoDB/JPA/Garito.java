package es.jaolve.QCHParserM.MongoDB.JPA;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * Representa una entitat JPA per a Mongo
 * Garito 
 * 
 * @author jaolve
 *
 */
@Entity("Garito")
public class Garito {
	
	@Id
	private String nom;
	private String url;
	private String direccioLlarga;
	private String direccioCurta;
	

	/**
	 * Contructor
	 * 
	 */
	public Garito()
	{
		this.nom 			= "";
		this.url 			= "";
		this.direccioLlarga = "";
		this.direccioCurta 	= "";
	}
	
	/**
	 * Constructor
	 * 
	 * @param nom
	 */
	public Garito(String nom)
	{
		this.nom 			= nom;
		this.url 			= "";
		this.direccioLlarga = "";
		this.direccioCurta 	= "";
		
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDireccioLlarga() {
		return direccioLlarga;
	}

	public void setDireccioLlarga(String direccioLlarga) {
		this.direccioLlarga = direccioLlarga;
	}

	public String getDireccioCurta() {
		return direccioCurta;
	}

	public void setDireccioCurta(String direccioCurta) {
		this.direccioCurta = direccioCurta;
	}

	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}

	
}
