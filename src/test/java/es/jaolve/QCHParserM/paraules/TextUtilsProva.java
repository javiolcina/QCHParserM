package es.jaolve.QCHParserM.paraules;

import java.util.Vector;

public class TextUtilsProva {

	public static void main(String[] args) {

		Vector<String> stringsRotats = TextUtils.rotarAccents("Val[è]ncia");
		
		for (String string : stringsRotats) {
			System.out.println(string);
		}
	}

}
