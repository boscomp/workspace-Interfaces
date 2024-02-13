package app.gui.modelo;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Partido {
	@BsonProperty(value="Season")
	private String Season;
	@BsonProperty(value="Date")
	private String Date;
	@BsonProperty(value="Time")
	private String Time;
	@BsonProperty(value="HomeTeam")
	private String HomeTeam;
	@BsonProperty(value="AwayTeam")
	private String AwayTeam;
	@BsonProperty(value="FTHG")
	private Integer FTHG;
	@BsonProperty(value="FTAG")
	private Integer FTAG;
	@BsonProperty(value="FTR")
	private String FTR;
	@BsonProperty(value="HY")
	private Integer HY;
	@BsonProperty(value="AY")
	private Integer AY;
	@BsonProperty(value="HR")
	private Integer HR;
	@BsonProperty(value="AR")
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
