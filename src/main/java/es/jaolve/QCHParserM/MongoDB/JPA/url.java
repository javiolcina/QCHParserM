package es.jaolve.QCHParserM.MongoDB.JPA;

import java.sql.Timestamp;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("url")
public class url {
	    public url() {
	}
		@Id
	    private ObjectId id;
	    private String nom;
	    private String url;
	    private String artiste;
	    private Timestamp lastAcces;
	    private Timestamp lastChange;
		public ObjectId getId() {
			return id;
		}
		public void setId(ObjectId id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getArtiste() {
			return artiste;
		}
		public void setArtiste(String artiste) {
			this.artiste = artiste;
		}
		public Timestamp getLastAcces() {
			return lastAcces;
		}
		public void setLastAcces(Timestamp lastAcces) {
			this.lastAcces = lastAcces;
		}
		public Timestamp getLastChange() {
			return lastChange;
		}
		public void setLastChange(Timestamp lastChange) {
			this.lastChange = lastChange;
		}

	    
}
