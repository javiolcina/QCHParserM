package es.jaolve.QCHParserM.net.html;

import java.io.*;  
import javax.swing.text.html.*;  
import javax.swing.text.html.parser.*;

import es.jaolve.QCHParserM.net.JGet;  
  
/**
 * Classe que converteix html en Text
 * Basado en tecnologia https://docs.oracle.com/javase/7/docs/api/javax/swing/text/html/HTMLEditorKit.ParserCallback.html
 * 
 * @author jaolve
 *
 */
public class Html2Text extends HTMLEditorKit.ParserCallback {  
 StringBuffer s;  
  
 public Html2Text() {}  
  
 public void parse(Reader in) throws IOException {  
   s = new StringBuffer();  
   ParserDelegator delegator = new ParserDelegator();  
   // the third parameter is TRUE to ignore charset directive  
   delegator.parse(in, this, Boolean.TRUE);  
 }  
  
 public void handleText(char[] text, int pos) {  
   s.append(text); 
   s.append("\n");
 }  
  
 public String getText() {  
   return s.toString();  
 }  
 
 /**
  * Funció estàtica 
  * 
  * @param in
  * @return
  */
 public static String textFromURL(Reader in)
 {
	try {
		 Html2Text parser = new Html2Text();  
	     parser.parse(in); 
	     in.close();  
	     return parser.getText();	
	} catch (Exception e) {
		System.out.println("textFromURL.Exception:"+e);
		return "";
	}
	 
 }
  
 public static void main (String[] args) {  
   try {  
     // the HTML to convert  
     //FileReader in = new FileReader("E:\\jolcina\\fuentes\\workspaceJava2017\\QCHParserM\\doc\\infoRelease.html");
 	 FileReader in = new FileReader("E:\\jolcina\\fuentes\\workspaceJava2017\\QCHParserM\\src\\test\\files\\Botifarra_.html");
     System.out.println(Html2Text.textFromURL(in));  
   }  
   catch (Exception e) {  
     e.printStackTrace();  
   }  
 }  
}  
