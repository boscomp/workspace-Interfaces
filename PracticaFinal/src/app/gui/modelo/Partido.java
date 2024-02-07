package app.gui.modelo;

public class Partido {
	private String season;
	private String fecha;
	private String hora;
	private String local;
	private String visitante;
	private Integer golesLocal;
	private Integer golesVisitante;
	private String ganador;
	private Integer amarillasLocal;
	private Integer amarillasVisitante;
	private Integer rojasLocal;
	private Integer rojasVisitante;
	public Partido() {
		
	}
	public Partido(String season, String fecha, String hora, String local, String visitante, Integer golesLocal,
			Integer golesVisitante, String ganador, Integer amarillasLocal, Integer amarillasVisitante,
			Integer rojasLocal, Integer rojasVisitante) {
		super();
		this.season = season;
		this.fecha = fecha;
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.ganador = ganador;
		this.amarillasLocal = amarillasLocal;
		this.amarillasVisitante = amarillasVisitante;
		this.rojasLocal = rojasLocal;
		this.rojasVisitante = rojasVisitante;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public Integer getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}
	public Integer getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	public Integer getAmarillasLocal() {
		return amarillasLocal;
	}
	public void setAmarillasLocal(Integer amarillasLocal) {
		this.amarillasLocal = amarillasLocal;
	}
	public Integer getAmarillasVisitante() {
		return amarillasVisitante;
	}
	public void setAmarillasVisitante(Integer amarillasVisitante) {
		this.amarillasVisitante = amarillasVisitante;
	}
	public Integer getRojasLocal() {
		return rojasLocal;
	}
	public void setRojasLocal(Integer rojasLocal) {
		this.rojasLocal = rojasLocal;
	}
	public Integer getRojasVisitante() {
		return rojasVisitante;
	}
	public void setRojasVisitante(Integer rojasVisitante) {
		this.rojasVisitante = rojasVisitante;
	}
	
	
}
