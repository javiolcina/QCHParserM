package es.jaolve.QCHParserM.MongoDB.JPA;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Representa una entitat JPA per a Mongo
 * 
 * @author jaolve
 *
 */

@Entity("Artista")
public class Artiste {

	@Id
	private String id;
	private String nom;
	private List<String> altresNoms = new ArrayList<String>();
	private List<String> espectacles = new ArrayList<String>();
	private String url;
	private String parsing_ini;
	private String parsing_fi;
	private String marca_seccio;

	public List<String> getEspectacles() {
		return espectacles;
	}

	public String getParsing_ini() {
		return parsing_ini;
	}

	public void setParsing_ini(String parsing_ini) {
		this.parsing_ini = parsing_ini;
	}

	public String getParsing_fi() {
		return parsing_fi;
	}

	public void setParsing_fi(String parsing_fi) {
		this.parsing_fi = parsing_fi;
	}

	public String getMarca_seccio() {
		return marca_seccio;
	}

	public void setMarca_seccio(String marca_seccio) {
		this.marca_seccio = marca_seccio;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public Artiste()
	{
		this.nom = "";
	}
	
	public Artiste(String nom)
	{
		this.nom = nom;
	}

	public List<String> getAltresNoms() {
		return altresNoms;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void addEspectable(String espectacle) {
		this.espectacles.add(espectacle);
	}
	
	public void addAltreNom(String altreNom) {
		this.altresNoms.add(altreNom);
	}
	
	public String toString()
	{
		StringBuffer sB = new StringBuffer();
		sB.append("nom:"+nom);
		//private List<String> altresNoms = new ArrayList<String>();
		//private List<String> espectacles = new ArrayList<String>();
		sB.append("\n\turl:"+url);
		sB.append("\n\tparsing_ini:"+parsing_ini);
		sB.append("\n\tparsing_fi:"+parsing_fi);
		sB.append("\n\tmarca_seccio:"+marca_seccio+"\n");
		
		return sB.toString();
	}
	

}
