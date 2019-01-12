package es.jaolve.QCHParserM.paraules;

import java.util.Vector;

/**
 * Sintagma representa un nombre y sus sinónimos
 * 
 * @author jaolve
 *
 */
public class Sintagma {
	
	//Propietats
	private String nom = null;

	private Vector<String> sinonims = null;
	
	/**
	 * Constructor
	 * 
	 * @param nom
	 */
	public Sintagma(String nom) {
		super();
		this.nom = nom;
		this.sinonims = new Vector<String>();
	}
	
	/**
	 * Torna el nom de la paraula
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
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
	 * Afegim sinonims
	 * 
	 * @param sinonims
	 */
	public void addSinonims(Vector<String> sinonims) {
		this.sinonims = sinonims;
	}
	/**
	 * Compara un nom i el busca en el nom del sintagma i en els sinonims
	 * 
	 * @param nomx
	 * @return
	 */
	public boolean esSintagma(String nomx)
	{
		boolean result = false;

		// Es igual al nom
		if (nom.equalsIgnoreCase(nomx))
		{
			result = true;
			System.out.println(" **** Sintagma detectada");
		}
		else
		{
			// O algún dels sinónims
			for (int i = 0 ; i< sinonims.size() ; i++ )
			{
				if ( sinonims.get(i).equalsIgnoreCase(nomx) )
				{
					result = true;				
					System.out.println(" *** sinonim detectada");
				}	
			}
		}
		return result;
	}
	
	/**
	 * Comprova si un text conté sintagma o els seus sinónims
	 * 
	 * @param text
	 * @return
	 */
	public boolean teSintagma(String text)
	{
		boolean result = false;

		// Es igual al nom
		if (text.indexOf(nom)!=-1)
			result = true;
		else
		{
			// O algún dels sinónims
			for (int i = 0 ; i< sinonims.size() ; i++ )
			{
				if (text.indexOf(nom)!=-1)
					result = true;				
			}
		}
		return result;
		
	}
}
