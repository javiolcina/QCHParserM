package es.jaolve.QCHParserM.cor.artistes;

import es.jaolve.QCHParserM.MongoDB.JPA.Artiste;
import junit.framework.TestCase;

public class ArtistesProva extends TestCase {
    /**
     * Obtenció d'un Artiste a partir d'un string
     */
    public void testobtencioArtiste()
    {
    	System.out.println("TEST."+this.getName());
    	
    	//Carreguem els artistes
    	Artistes.carregaArtistaFromMongo();
    	
    	assertTrue("No s'han carregat artistes", Artistes.getNumArtistesCarregats()>0);
    	
    	
    	//Proves amb botifarra
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Boti").getNom()
    			,"Pep Gimeno 'Botifarra'");  
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Botifarra").getNom()
    			,"Pep Gimeno 'Botifarra'");  
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Botifarra").getNom()
    			,"Pep Gimeno 'Botifarra'");  
    	    	

    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("\"Botifarra\"").getNom()
    			,"Pep Gimeno 'Botifarra'");  
    	

    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Pep Gimeno").getNom()
    			,"Pep Gimeno 'Botifarra'");
    	
    	
    	assertNull("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Pe Laguarda"));  
    	
 
    	
    	//Proves Quatlimbet
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Quatlimbet").getNom()
    			,"Quatlimbet");  
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Quatlimbe").getNom()
    			,"Quatlimbet");  
    	
    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Qualimbet").getNom()
    			,"Quatlimbet");  
    	    	

    	assertEquals("No s'ha obtingut un nom correcte", 
    			Artistes.getArtistaFromString("Quaimbett").getNom()
    			,"Quatlimbet");  
    	
    	
    	
    	
        
        System.out.println("TEST."+this.getName()+": OK");
    }
}
