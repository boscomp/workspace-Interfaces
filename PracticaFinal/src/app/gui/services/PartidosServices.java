package app.gui.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.gui.modelo.Partido;
import app.mongo.MongoSession;

public class PartidosServices {

	public List<Partido> obtenerListaPartidos() {

		
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Partido> mcol = db.getCollection("partidos", Partido.class);
		Bson filtro =Filters.regex("HomeTeam", ".*Val.*");
		FindIterable<Partido> result = mcol.find(filtro);

		MongoCursor<Partido> cursor = result.cursor();
		List <Partido> partidos = new ArrayList<Partido>();
		
		while (cursor.hasNext()) {
			System.out.println("Hola: "+cursor.next().getAwayTeam());
			partidos.add(cursor.next());
	

		};
		return partidos;
	}

	public List<Partido> partidosBetis() {
		List<Partido> partidosBetis = new ArrayList<Partido>();
		List<Partido> lista = obtenerListaPartidos();
		for (Partido partido : lista) {

//			if (partido.getLocal().equals("Real Betis")) {
//				partidosBetis.add(partido);
//			}

			if (partido.getHomeTeam().equals("Real Betis")) {
				partidosBetis.add(partido);
			}

		}
		return partidosBetis;

	}

}
