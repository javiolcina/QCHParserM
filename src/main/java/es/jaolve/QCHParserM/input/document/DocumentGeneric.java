package es.jaolve.QCHParserM.input.document;


/**
 * Instancia un document i torna les seccions
 * 
 * @author jaolve
 *
 */
public class DocumentGeneric extends DocumentAbstract {

	public DocumentGeneric() {
		super();
	}


	/**
	 * Accions de filtrat al contingut
	 * Valors que pot gastar:
	 * - parsing_ini
	 * - parsing_fin
	 * 
	 */
	public String filtraContigut(String origen) {
		int inici 	= 0;
		int fi  	= origen.length();
		if (parsing_ini != null)
			inici = origen.indexOf(parsing_ini);
		if (parsing_fin != null)
			fi = origen.indexOf(parsing_fin);
		return origen.substring(inici, fi );
	}

	
	
	
	
}
