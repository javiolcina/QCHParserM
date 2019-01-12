package es.jaolve.QCHParserM.input.garitos;

 
import es.jaolve.QCHParserM.MongoDB.DTO.GaritosMongo;

/**
 * Classe per a carregar garitos a la base de dades Mongo
 * 
 * 
 * @author jaolve
 *
 */
public class CarregaGaritosMongo {
	
	public static void main(String[] args) {
		GaritosMongo garitoMongo = new GaritosMongo();
		//garitoMongo.getGaritos();
		garitoMongo.garitoToMongo();
		garitoMongo.desconectar();
	}

}
