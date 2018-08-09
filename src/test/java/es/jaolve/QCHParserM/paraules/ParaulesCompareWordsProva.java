package es.jaolve.QCHParserM.paraules;

public class ParaulesCompareWordsProva {

	public static void main(String[] args) {
		
	  final String x = " one two three FOUR";
	  final String y = "five four,   six three ";

	  final String[] common = TextUtils.commonWords(x, y);

	  System.out.println ("Common words: ");
	  System.out.println (common.toString());
	  System.out.println ("\nQuantity: #" + common.length);


	}

}
