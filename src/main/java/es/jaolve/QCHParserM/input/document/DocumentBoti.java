package es.jaolve.QCHParserM.input.document;

import java.util.List;

import javax.swing.text.Document;

import org.apache.log4j.Logger;

import es.jaolve.QCHParserM.cor.artistes.Artistes;

/**
 * Instancia un document boti i torna les seccions
 * 
 * @author jaolve
 *
 */
public class DocumentBoti extends DocumentAbstract {
	
	final static Logger logger = Logger.getLogger(DocumentBoti.class);

	public DocumentBoti() {
		super( );
		setMarcaSeparacio("– ");
		setArtistaPerDefecte(Artistes.getArtistaFromString("Boti").getNom());
	}
	
	//Funcions de servei
	protected String carregaDocumentDeFitxer(String documentLocal)
	{
		String resultado = 
				"- Dimecres 21 i dijous 22 de desembre de 2016: “Botifarra” en solitari (el Genovés, la Costera)."+
				"- Divendres 23 de desembre de 2016: espectacle Nadales (València, l’Horta)."+
		 		"- Dimecres 28 de desembre de 2016: espectacle Ja ve Nadal (Valencia, l’Horta).";
		
		return resultado;
	}

	@Override
	public String filtraContigut(String origen) {
		int inici 	= origen.indexOf("ANY 2018");
		int fi  	= origen.indexOf("ANY 2017");
		return origen.substring(inici, fi );
	}

}
