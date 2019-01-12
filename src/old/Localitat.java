package es.jaolve.QCHParserM.cor.localitats;

import java.util.StringTokenizer;
import java.util.Vector;

import es.jaolve.QCHParserM.cor.paraules.SintagmaUtils;
import es.jaolve.QCHParserM.input.municipis.MunicipioJson;

/**
 * Representa una localitat per mapejar-la al JSON i
 * afegeix funcionalitat.
 * 
 * @author jaolve
 *
 */
public class Localitat {
	
	//Propietats
	private String nom 	= null;
	private String id 	= null;
	//Altres noms per els que es coneix la localitat
	private Vector<String> sinonims = null;
	//LlocsQCH concrets dins de la localitat
	private Vector<String> llocs = null;
	


	/**
	 * Constructor
	 * 
	 * @param nom
	 */
	public Localitat(String nom, String id) {
		super();
		this.nom 		= nom;
		this.id 		= id;
		this.sinonims 	= new Vector<String>();
		this.llocs		= new Vector<String>();
	}
	
	/**
	 * Constructor
	 * 
	 * @param municipi
	 */
	public Localitat(MunicipioJson municipi) {
		super();
		this.sinonims = new Vector<String>();
		this.llocs	  = new Vector<String>();
		
		this.id = municipi.getId();
		
		StringTokenizer st = new StringTokenizer(municipi.getNm());
		nom = LocalitatsUtils.rotaComa(st.nextToken("/"));
	     while (st.hasMoreTokens()) {
	         addSinonim(LocalitatsUtils.rotaComa(st.nextToken("/")));
	     }
	}
	
	/**
	 * Torna el nom de la localitat
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Torna el id de la localitat
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Afegim sinonim
	 * 
	 * @param sinonim
	 */
	public void addSinonim(String sinonim) {
		this.sinonims.add(sinonim);
	}

	/**
	 * Afegeix un lloc concret a la localitat
	 * 
	 * @param lloc
	 */
	public void addLlocs(String lloc) {
		llocs.add(lloc);
	}
	
	/**
	 * Compara un nom i el busca en el nom de la localitat i en els sinonims
	 * 
	 * @param nomx
	 * @return
	 */
	public boolean esLocalitat(String nomx)
	{
		boolean result = false;

		// Es igual al nom
		if (nom.equalsIgnoreCase(nomx))
		{
			result = true;
			System.out.println(" **** LocalitatJPA detectada");
		}
		else
		{
			// O algún dels sinónims
			for (int i = 0 ; i< sinonims.size() ; i++ )
			{
				if ( sinonims.get(i).equalsIgnoreCase(nomx) )
				{
					result = true;				
					System.out.println(" *** LocalitatJPA detectada");
				}	
			}
		}
		return result;
	}
	
	/**
	 * Comprova si un text conté localitat o els seus sinónims
	 * 
	 * @param text
	 * @param exacto: true exacto, false serca aproximada
	 * @return
	 */
	public boolean teLocalitat(String text, boolean exacto)
	{
		boolean result = false;

		// Es igual al nom
		if (text.indexOf(nom)!=-1 || 
				(!exacto && SintagmaUtils.sintagmesIguals(nom, text, 75, 1)))
			result = true;
		else
		{
			// O algún dels sinónims
			for (int i = 0 ; i< sinonims.size() ; i++ )
			{
				if (text.indexOf(sinonims.get(i))!=-1 || 
						(!exacto && SintagmaUtils.sintagmesIguals(nom, text, 75, 1)))
					result = true;				
			}
		}
		return result;
		
	}
	
	public boolean isMunicipi(String llocStr) {
		boolean resultat = false;
		resultat =  (nom.equalsIgnoreCase(llocStr)
				|| SintagmaUtils.sintagmesIguals(nom, llocStr, 75, 1));
		
		//Altres noms
		/*if (!resultat && altresnoms != null)
		{
			Iterator<String> i = altresnoms.iterator();
			while (!resultat && i.hasNext()) {
				resultat = SintagmaUtils.sintagmesIguals(i.next(), llocStr, 75, 1) ;
				
			}
		}*/
		return false;
	}

	/**
	 * Indica si el llocStr se ha trobat la localitat
	 * 
	 * @param llocStr
	 * @return
	 */
	/*public boolean teLocalitat(String llocStr) {
		return llocStr.indexOf(nom)!=-1;
	}*/
}
