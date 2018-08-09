package es.jaolve.QCHParserM.paraules;

import java.util.Arrays;

public class ParaulesSplitProva {

	public static void main(String[] args) {
		
	  final String x = "Dani Miquel";
	  final String y = "Pep Gimeno \"Botifarra\" ";

	  String [] result = x.split("[^a-zA-Z]+");//("[^a-z]+");

	  String [] result2 = y.split("[^a-zA-Z\"]+");
	  
	  System.out.println(Arrays.toString(result));
	  System.out.println(Arrays.toString(result2));
	}

}
