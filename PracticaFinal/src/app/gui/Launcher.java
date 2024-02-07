package app.gui;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.mongo.MongoSession;

public class Launcher {
	public static void main(String[] args) {
	//	App.main(args);
		
		MongoClient mc = MongoSession.getMongoClient();
		MongoDatabase db = mc.getDatabase("futbol");
		MongoCollection<Document> col = db.getCollection("partidos");
		Bson filtro = Filters.regex("HomeTeam", ".*Val.*");
		FindIterable<Document> result = col.find(filtro);
		MongoCursor<Document> cursor = result.cursor();
		int i=0;
		while (cursor.hasNext()) {
			
			//Al hacer la búsqueda de nuevo cada vez que pasa por el cursor, puedo imprimir lo que quiero
			//no lo siguiente a lo que quiero
	
			//LO PUEDO PASAR A CLASE PARTIDO Y DARSELO A TABLA
			FindIterable<Document> resultado = col.find(filtro).skip(i);
			if (cursor.next().get("AwayTeam").equals("Mallorca")) {
				
				System.out.println("Temporada: "+resultado.first().get("Season")+". Local: "+resultado.first().get("HomeTeam")+". Visitante: "+resultado.first().get("AwayTeam"));
				
			}
			i++;
		}
//		System.out.println(result.first().get("AwayTeam"));
		
	}
}
