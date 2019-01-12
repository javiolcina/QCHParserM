package es.jaolve.QCHParserM.url;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.jaolve.QCHParserM.net.JGet;
import es.jaolve.QCHParserM.net.html.Html2Text;

/**
 * Classe que permet a partir d'un url obtindre el contingut en brut d'eixe URL
 * 
 * @author jaolve
 *
 */
public class URL {

	// atributs
	private String url = null;
	
	
	/**
	 * Constructor
	 * 
	 * @param url
	 */
	public URL(String url) {
		super();
		this.url = url;
	}

	/**
	 * Torna el contingut d'una adreça URL
	 * 
	 * @return
	 */
	public String getContingut()
	{
		
		InputStreamReader in = JGet.getInputStream(url);
		Html2Text parser = new Html2Text();  
	     try {
			parser.parse(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     return parser.getText();
		
		
	}
	

	public static void main(String[] args) {
		URL u = new URL("https://www.uv.es");
		System.out.println(u.getContingut());

	}


}
