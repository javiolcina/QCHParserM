package es.jaolve.QCHParserM.paraules;

import java.util.HashSet;

import es.jaolve.QCHParserM.cor.paraules.TextUtils;

public class filtraHashSetDeParaulesCurtesProva {

	public static void main(String[] args) {
		
		HashSet<String> in = new HashSet<String>();
		in.add("Hola");
		in.add("com");
		in.add("estas?");
		HashSet<String> out = new HashSet<String>();
		
		out = TextUtils.filtraHashSetDeParaulesCurtes(in,4);
		System.out.println(out);
	}

}
