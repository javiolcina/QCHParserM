package es.jaolve.QCHParserM.localitats;

import es.jaolve.QCHParserM.cor.localitats.Localitats;
import junit.framework.TestCase;

public class TeLocalitatsProva     
	extends TestCase{
    
	public void testTrobantLocalitas( )
    {
		String texto = "la Pobla del Duc";
		
    	System.out.println("TEST."+this.getName());
		
		//Carreguem 
		Localitats.loadLocalitatsFromMunicipiosFile();
		assertEquals(texto, Localitats.teLocalitat(texto).getNom());
		System.out.println(texto + " ---> " + Localitats.teLocalitat(texto).getNom());
    
    	System.out.println("TEST."+this.getName()+ " OK");
    }
}
