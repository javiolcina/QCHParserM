package es.jaolve.QCHParserM.localitats;

import junit.framework.TestCase;

public class LocalitatsUtilrotarComProva extends TestCase {
    /**
     * Test de rotació de l'article
     */
    public void testRotarComProva()
    {
    	String textCorrecte = "La Nucia";
    	
    	System.out.println("TEST."+this.getName());
    	
        assertEquals(LocalitatsUtils.rotaComa(textCorrecte),textCorrecte);
        assertEquals(LocalitatsUtils.rotaComa("Nucia, La").trim(),textCorrecte);
        assertEquals(LocalitatsUtils.rotaComa("Nucia,La").trim(),textCorrecte);
        assertEquals(LocalitatsUtils.rotaComa("Nucia,   La").trim(),textCorrecte);
        assertEquals(LocalitatsUtils.rotaComa("Torre de les Mançanes, la").trim()
        			,"la Torre de les Mançanes");    
        
        System.out.println("TEST."+this.getName()+": OK");
    }
}
