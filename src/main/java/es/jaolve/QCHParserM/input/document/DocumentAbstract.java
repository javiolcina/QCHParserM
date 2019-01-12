package es.jaolve.QCHParserM.input.document;

import java.util.List;

public abstract class DocumentAbstract {
	
	
	private String marca_seccio				= null;
	protected String contingut				= null;
	private String artistaPerDefecte		= null;
	protected String parsing_ini		 	= null;
	protected String parsing_fin 			= null;
	
	
	
	
	public String getParsing_ini() {
		return parsing_ini;
	}

	public void setParsing_ini(String parsing_ini) {
		this.parsing_ini = parsing_ini;
	}

	public String getParsing_fin() {
		return parsing_fin;
	}

	public void setParsing_fin(String parsing_fin) {
		this.parsing_fin = parsing_fin;
	}


	public String getArtistaPerDefecte() {
		return artistaPerDefecte;
	}

	public void setArtistaPerDefecte(String artistaPerDefecte) {
		this.artistaPerDefecte = artistaPerDefecte;
	}

	public String getContingut() {
		return contingut;
	}

	public void setContingut(String contingut) {
		this.contingut = filtraContigut(contingut);
	}

	/**
	 * Constructor 
	 */
	public DocumentAbstract() {
  
	}

	/**
	 * Constructor 
	 * @param  String document
	 * 
	 * 
	 */
	/*public DocumentAbstract(String document) {
		this.document = document;
	}*/
	
	/**
	 * Defeneix una marca de separació entre seccions
	 * 
	 * @param marcaSeparacio
	 */
	public void setMarcaSeparacio(String marcaSeparacio) {
		this.marca_seccio = marcaSeparacio;
	}


	/**
	 * Torna les seccions trobades al document
	 * 
	 * @return
	 */
	public List<String> getSeccions()
	{
		return DocumentUtils.getSeccions(marca_seccio, contingut);
	}

	/**
	 * Cada implementació de Document ha de filtrar el contingut
	 * 
	 * @param origen
	 * @return
	 */
	public abstract String filtraContigut(String origen);

}