package es.jaolve.QCHParserM.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.jaolve.QCHParserM.net.html.Html2Text;

/**
 * Classe que permet a partir d'un url obtindre el contingut en brut d'eixe WebContent
 * 
 * @author jaolve
 *
 */
public class WebContent {

	// atributs
	private String url = null;
	
	
	/**
	 * Constructor
	 * 
	 * @param url
	 */
	public WebContent(String url) {
		super();
		this.url = url;
	}

	/**
	 * Torna el contingut d'una adreça WebContent
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
		WebContent u = new WebContent("https://www.uv.es");
		System.out.println(u.getContingut());

	}


}
