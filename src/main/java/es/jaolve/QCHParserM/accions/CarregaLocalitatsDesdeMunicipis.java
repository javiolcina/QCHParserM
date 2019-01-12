package es.jaolve.QCHParserM.accions;

import es.jaolve.QCHParserM.cor.localitats.Localitats;

public class CarregaLocalitatsDesdeMunicipis {

	public static void main(String[] args) {
		Localitats.loadLocalitatsFromMunicipiosFile();
		
		Localitats.toMongo();

	}

}
