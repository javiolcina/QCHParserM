package es.jaolve.QCHParserM;

public class Params {
	
	/**
	 * Parametres d'execució de l'aplicació
	 * 
	 */
	public static final int DOCUMENT_SECCIO_MINIMA = 20;
	
	public static final boolean DEBUG_ARTISTES_JPA			= true;
	public static final boolean DEBUG_TEXT					= true;	
	public static final boolean DEBUG_SECCIONS 				= false;
	public static final boolean DEBUG_EVENT 				= false;
	public static final boolean DEBUG_sintagmesIguals 		= false;
	
	public static final int commonWords_minimaLongitud	= 4;
	
	/**
	 * Torna una representació String del paràmetres actuals
	 * 
	 * @return
	 */
	public static String toStringParams()
	{
		StringBuffer sB = new StringBuffer();
		sB.append("\n\tDOCUMENT_SECCIO_MINIMA: "+DOCUMENT_SECCIO_MINIMA+"\n");
		
		sB.append("\tDEBUG_ARTISTES_JPA: "		+ DEBUG_ARTISTES_JPA+"\n");
		sB.append("\tDEBUG_TEXT: "				+ DEBUG_TEXT+"\n");	
		sB.append("\tDEBUG_SECCIONS: "			+ DEBUG_SECCIONS+"\n");
		sB.append("\tDEBUG_EVENT: "				+ DEBUG_EVENT+"\n");
		sB.append("\tDEBUG_sintagmesIguals: "		+ DEBUG_sintagmesIguals+"\n");
		sB.append("\tcommonWords_minimaLongitud: "+ commonWords_minimaLongitud+"");	
		return sB.toString();
	}
}
