package app.gui.services;

import java.util.ArrayList;
import java.util.Collections;
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

	/**
	 * lista para obtenerlo todo lo de la bbdd
	 * 
	 * @return devuelve todos los partidos
	 */
	public List<Partido> obtenerListaPartidos() {

		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Partido> mcol = db.getCollection("partidos", Partido.class);

		FindIterable<Partido> result = mcol.find();

		MongoCursor<Partido> cursor = result.cursor();
		List<Partido> partidos = new ArrayList<Partido>();

		while (cursor.hasNext()) {

			partidos.add(cursor.next());

		}
		;
		// Con esto imprimo primero los resultados más actuales
		Collections.reverse(partidos);
		return partidos;
	}

	// TODO: cambiar nombre posiblemente para usarlo si quiero buscar a equipo no
	// favorito
	public List<Partido> partidosEquipoFavorito(String favorito) {
		List<Partido> lista = obtenerListaPartidos();
		// Lista que recogerá todos los partidos del equipo seleccionado
		List<Partido> partidosFav = new ArrayList<Partido>();
		for (Partido partido : lista) {
			if (partido.getLocal().equals(favorito) || partido.getVisitante().equals(favorito)) {
				partidosFav.add(partido);
			}

		}
		if (favorito.isBlank()) {
			return lista;
		}
		return partidosFav;

	}

	public List<Partido> partidosPorTemporada(List<Partido> listaAFiltrar, String temp) {
		List<Partido> partidosFiltrados = new ArrayList<Partido>();
		for (Partido resultado : listaAFiltrar) {
			if (resultado.getTemporada().equals(temp)) {
				partidosFiltrados.add(resultado);
			}
		}
		return partidosFiltrados;

	}

	// TODO: METER OTRO TIPO DE FILTROS?
	public List<String> elegirEquipo() {
		List<Partido> lista = obtenerListaPartidos();
		// aquí agregaré todos los difrenetes equipos que han jugado en primera para
		// agregarlos a comboBox
		List<String> listaEquipos = new ArrayList<String>();
		for (Partido partido : lista) {
			// agrego el primer equipo que salga
			if (listaEquipos.isEmpty()) {
				listaEquipos.add(partido.getLocal());
			} else {
				// solo agrego equipos que no estén ya en la lista
				if (!listaEquipos.contains(partido.getLocal())) {
					listaEquipos.add(partido.getLocal());
				}
			}
		}
		// Ordeno la lista por orden alfabético para hacer más sencilla su búsqueda
		Collections.sort(listaEquipos);
		return listaEquipos;

	}

}
