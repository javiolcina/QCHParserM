package es.jaolve.QCHParserM.input.artistes;

import es.jaolve.QCHParserM.MongoDB.DTO.ArtistesMongoDto;

/**
 * Classe per a carregar artistes a la base de dades Mongo
 * 
 * 
 * @author jaolve
 *
 */
public class CarregaArtistesMongo {
	
	public static void main(String[] args) {
		
		ArtistesMongoDto artistesMongo = new ArtistesMongoDto();
		artistesMongo.getArtistes();
		//artistesMongo.artistaToMongo();
		artistesMongo.desconectar();
	}

}
