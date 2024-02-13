import java.util.List;

import app.gui.modelo.Partido;
import app.gui.services.PartidosServices;

public class test {
public static void main(String[] args) {
	PartidosServices ps = new PartidosServices();
	List<Partido> partidos=ps.obtenerListaPartidos();
	for (Partido partido : partidos) {
		System.out.println(partido.getAwayTeam());
	}
}
}
