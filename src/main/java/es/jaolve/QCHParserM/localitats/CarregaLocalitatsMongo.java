package es.jaolve.QCHParserM.localitats;

 
import es.jaolve.QCHParserM.MongoDB.DTO.LocalitatMongo;

/**
 * Classe per a carregar localitats a la base de dades Mongo
 * 
 * 
 * @author jaolve
 *
 */
public class CarregaLocalitatsMongo {
	
	public static void main(String[] args) {
		LocalitatMongo localitatsMongo = new LocalitatMongo();
		//localitatMongo.getLocalitats();
		localitatsMongo.localitatToMongo();
		localitatsMongo.desconectar();
	}

}
