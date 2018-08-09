package es.jaolve.QCHParserM.localitats;

/**
 * Representa el municipi tal qual ve del fitxer del ministeri JSON
 * 
 * @author jaolve
 *
 */
public class MunicipioJson {
	String id = null;
	String nm = null;
	
	/**
	 * Constructor que equivale al objeto JSON
	 * 
	 * @param id
	 * @param nm
	 */
	public MunicipioJson(String id, String nm) {
		super();
		this.id = id;
		this.nm = nm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNm() {
		return nm;
	}


	public void setNm(String nm) {
		this.nm = nm;
	}


	
	
		
}
