package es.jaolve.QCHParserM.localitats;

import junit.framework.TestCase;

public class TeLocalitatsProva     
	extends TestCase{
    
	public void testTrobantLocalitas( )
    {
		String texto = "la Pobla del Duc";
		
    	System.out.println("TEST."+this.getName());
		
		//Carreguem 
		Localitats.load();
		assertEquals(texto, Localitats.teLocalitat(texto).getNom());
		System.out.println(texto + " ---> " + Localitats.teLocalitat(texto).getNom());
    
    	System.out.println("TEST."+this.getName()+ " OK");
    }
}
