package app.gui.modelo;

public class Partido {
	private String Season;
	private String Date;
	private String Time;
	private String HomeTeam;
	private String AwayTeam;
	private Integer FTHG;
	private Integer FTAG;
	private String FTR;
	private Integer HY;
	private Integer AY;
	private Integer HR;
	private Integer AR;
	public Partido() {
		
	}
	public Partido(String season, String date, String time, String homeTeam, String awayTeam, Integer fTHG,
			Integer fTAG, String fTR, Integer hY, Integer aY, Integer hR, Integer aR) {
		super();
		Season = season;
		Date = date;
		Time = time;
		HomeTeam = homeTeam;
		AwayTeam = awayTeam;
		FTHG = fTHG;
		FTAG = fTAG;
		FTR = fTR;
		HY = hY;
		AY = aY;
		HR = hR;
		AR = aR;
	}
	public String getSeason() {
		return Season;
	}
	public void setSeason(String season) {
		Season = season;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getHomeTeam() {
		return HomeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		HomeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return AwayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}
	public Integer getFTHG() {
		return FTHG;
	}
	public void setFTHG(Integer fTHG) {
		FTHG = fTHG;
	}
	public Integer getFTAG() {
		return FTAG;
	}
	public void setFTAG(Integer fTAG) {
		FTAG = fTAG;
	}
	public String getFTR() {
		return FTR;
	}
	public void setFTR(String fTR) {
		FTR = fTR;
	}
	public Integer getHY() {
		return HY;
	}
	public void setHY(Integer hY) {
		HY = hY;
	}
	public Integer getAY() {
		return AY;
	}
	public void setAY(Integer aY) {
		AY = aY;
	}
	public Integer getHR() {
		return HR;
	}
	public void setHR(Integer hR) {
		HR = hR;
	}
	public Integer getAR() {
		return AR;
	}
	public void setAR(Integer aR) {
		AR = aR;
	}
	
}
