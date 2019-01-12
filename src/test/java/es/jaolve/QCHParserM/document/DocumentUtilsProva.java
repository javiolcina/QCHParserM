package es.jaolve.QCHParserM.document;

import java.util.List;

import es.jaolve.QCHParserM.input.document.DocumentUtils;

public class DocumentUtilsProva {

    public static void main( String[] args )
    {
		String document = ""
				+ " secció1   \n"
				+ " secció2   \n"
				+ " secció3   \n"
				+ " secció4  ";
		
		List<String> seccions = DocumentUtils.getSeccions("   \n",document);
		System.out.println("Trobades "+seccions+" seccions");
    }
}
