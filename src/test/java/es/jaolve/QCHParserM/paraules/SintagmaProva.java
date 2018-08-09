package es.jaolve.QCHParserM.paraules;

public class SintagmaProva {

	public static void main(String[] args) {

		Sintagma sintagma = new Sintagma("Valencia");

		sintagma.addSinonim("València");
		sintagma.addSinonim("cap i casal");
		
		System.out.println("test 1 " + sintagma.esSintagma("valencia"));

		System.out.println("test 2 " + sintagma.esSintagma("València"));
		
		System.out.println("test 3 " + sintagma.esSintagma("Valéncia"));
		
		System.out.println("test 4 " + sintagma.esSintagma("cap i casal"));
	}

}
