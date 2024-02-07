package app.gui.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
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
//		MongoClient mc = MongoSession.getDatabase();
		
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Document> col = db.getCollection("partidos");
		Bson filtro = Filters.regex("HomeTeam", ".*Val.*");
		FindIterable<Document> result = col.find(filtro);
		MongoCursor<Document> cursor = result.cursor();
		List <Partido> partidos = new ArrayList<Partido>();
		
		while (cursor.hasNext()) {
			Partido p= new Partido();
			p.setSeason(cursor.next().get("Season").toString());

			p.setFecha(cursor.next().get("Date").toString());
			p.setHora(cursor.next().get("Time").toString());
			p.setLocal(cursor.next().get("HomeTeam").toString());
			p.setVisitante(cursor.next().get("AwayTeam").toString());
			p.setGolesLocal(Integer.valueOf(cursor.next().get("FTHG").toString()));
			p.setGolesVisitante(Integer.valueOf(cursor.next().get("FTAG").toString()));
			p.setGanador(cursor.next().get("FTR").toString());
			p.setAmarillasLocal((Integer.valueOf(cursor.next().get("HY").toString())));
			p.setAmarillasVisitante((Integer.valueOf(cursor.next().get("AY").toString())));
			p.setRojasLocal((Integer.valueOf(cursor.next().get("HR").toString())));
			p.setRojasVisitante((Integer.valueOf(cursor.next().get("AR").toString())));
			partidos.add(p);
		};
		return partidos;
	}
	public List<Partido> partidosBetis() {
		List <Partido> partidosBetis = new ArrayList<Partido>(); 
		List <Partido> lista=obtenerListaPartidos();
		for (Partido partido : lista) {
			if (partido.getLocal().equals("Real Betis")||partido.getVisitante().equals("Real Betis")) {
				partidosBetis.add(partido);
			}
		}
		return partidosBetis;
		
		
	}
	

}
