package es.jaolve.QCHParserM.accions;

import es.jaolve.QCHParserM.cor.localitats.Localitats;

/**
 * Dels llocs carregats en memoria
 * 
 * @author jaolve
 *
 */
public class CarregaLlocsALocalitats {
	
	public static void execute() 
	{
		Localitats.loadLocalitatsFromMunicipiosFile();
		
		
		
		Localitats.buscaLlocsPerLocalitats();
	}

	public static void main(String[] args) {
		execute();
	}

}
