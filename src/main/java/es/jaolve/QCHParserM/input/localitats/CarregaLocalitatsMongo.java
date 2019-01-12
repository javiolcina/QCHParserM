package es.jaolve.QCHParserM.input.localitats;

 
import java.util.List;

import es.jaolve.QCHParserM.MongoDB.DTO.LocalitatMongo;
import es.jaolve.QCHParserM.MongoDB.JPA.Localitat;

/**
 * Classe per a carregar localitats a la base de dades Mongo
 * 
 * 
 * @author jaolve
 *
 */
public class CarregaLocalitatsMongo {
	
	public static List<Localitat> getLocalitats()
	{
		LocalitatMongo localitatsMongo = new LocalitatMongo();
		List<Localitat> result = localitatsMongo.getLocalitats();
		localitatsMongo.desconectar();
		return result;
	}
	
	public static void main(String[] args) {
		LocalitatMongo localitatsMongo = new LocalitatMongo();
		localitatsMongo.localitatToMongoExample();
		localitatsMongo.desconectar();
	}

}
