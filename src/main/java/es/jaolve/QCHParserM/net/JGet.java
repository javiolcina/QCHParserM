package es.jaolve.QCHParserM.net;

import java.io.*;
import java.net.*;

/**
 * Classe que fa una connexions per a portar-se htmls d'Internet
 * 
 * @author jaolve
 *
 */
public class JGet
{

	/**
	 * Obté el html s'un url
	 * 
	 * @param url
	 * @return
	 */
	public static String getHTML(String url)
	{
		URL 			u 			= null;
		InputStream 	is 			= null;
		DataInputStream dis			= null;
		StringBuffer 	resultado	= new StringBuffer();
		String 			s			= null;

		try
		{
			u = new URL(url);
			is = u.openStream();
			dis = new DataInputStream(new BufferedInputStream(is));
			while ((s = dis.readLine()) != null)
			{
				resultado.append(s);
				//System.out.println(s);
			}
			is.close();
		}
		catch (MalformedURLException mue)
		{
			System.err.println("get");
			mue.printStackTrace();
			System.exit(2);
		}
		catch (IOException ioe)
	    {
			System.err.println("Oops- an IOException happened.");
			ioe.printStackTrace();
			System.exit(3);
	    }
		finally {
			return resultado.toString();
		}

	}

	/**
	 * Obté el html s'un url
	 * 
	 * @param url
	 * @return
	 */
	public static InputStreamReader getInputStream(String url)
	{
		URL 			u 	= null;
		InputStreamReader 	is 	= null;

		try
		{
			u = new URL(url);
			is = new InputStreamReader(u.openStream());
			
		}
		catch (IOException ioe)
	    {
			System.err.println("Oops- an IOException happened.");
			ioe.printStackTrace();
			System.exit(3);
	    }

		return is;
	}
	
	
	public static void main(String[] args) {
		System.out.println( getHTML("https://www.uv.es") );
		//getHTML("https://www.uv.es");
	}

}