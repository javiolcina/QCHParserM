package es.jaolve.QCHParserM;

import es.jaolve.QCHParserM.cor.artistes.ArtistesProva;
import es.jaolve.QCHParserM.localitats.LocalitatsUtilrotarComProva;
import es.jaolve.QCHParserM.localitats.TeLocalitatsProva;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTest {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(AppTest.suite());
		suite.addTestSuite(LocalitatsUtilrotarComProva.class);
		suite.addTestSuite(TeLocalitatsProva.class);
		suite.addTestSuite(ArtistesProva.class);
		
		//$JUnit-END$
		return suite;
	}

}
