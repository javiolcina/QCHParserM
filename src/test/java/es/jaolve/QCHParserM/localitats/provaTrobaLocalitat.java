package es.jaolve.QCHParserM.localitats;

import es.jaolve.QCHParserM.cor.localitats.Localitats;

/**
 * Prova para identificar localitats
 * 
 * @author jaolve
 *
 */
public class provaTrobaLocalitat {
    
	public static void main(String[] args) {
 
		String texto 		= "la Pobla del Duc";
		String resultado 	= null;
		
		//Carreguem 
		Localitats.loadLocalitatsFromMunicipiosFile();
		
		if (Localitats.teLocalitat(texto) != null)
			resultado = Localitats.teLocalitat(texto).getNom();
 
		System.out.println(texto + " -- (després de buscar) --> " + resultado);
    
    }
}
