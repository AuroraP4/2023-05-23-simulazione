package it.polito.tdp.baseball.model;

import java.util.Objects;

public class Team {

    private Integer iD;
    private Integer year;
    private String teamCode;
    private String divID;
    private Integer div_ID;
    private Integer teamRank;
    private Integer games;
    private Integer gamesHome;
    private Integer wins;
    private Integer losses;
    private String divisionWinnner;
    private String leagueWinner;
    private String worldSeriesWinnner;
    private Integer runs;
    private Integer hits;
    private Integer homeruns;
    private Integer stolenBases;
    private Integer hitsAllowed;
    private Integer homerunsAllowed;
    private String name;
    private String park;

    public Team(Integer iD, Integer year, String teamCode, String divID, Integer div_ID, Integer teamRank,
			Integer games, Integer gamesHome, Integer wins, Integer losses, String divisionWinnner, String leagueWinner,
			String worldSeriesWinnner, Integer runs, Integer hits, Integer homeruns, Integer stolenBases,
			Integer hitsAllowed, Integer homerunsAllowed, String name, String park) {
		this.iD = iD;
		this.year = year;
		this.teamCode = teamCode;
		this.divID = divID;
		this.div_ID = div_ID;
		this.teamRank = teamRank;
		this.games = games;
		this.gamesHome = gamesHome;
		this.wins = wins;
		this.losses = losses;
		this.divisionWinnner = divisionWinnner;
		this.leagueWinner = leagueWinner;
		this.worldSeriesWinnner = worldSeriesWinnner;
		this.runs = runs;
		this.hits = hits;
		this.homeruns = homeruns;
		this.stolenBases = stolenBases;
		this.hitsAllowed = hitsAllowed;
		this.homerunsAllowed = homerunsAllowed;
		this.name = name;
		this.park = park;
	}

	public Integer getID(){
        return iD;
    }

    public void setID(Integer iD){
        this.iD=iD;
    }

    public Integer getYear(){
        return year;
    }

    public void setYear(Integer year){
        this.year=year;
    }

    public String getTeamCode(){
        return teamCode;
    }

    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }

    public String getDivID(){
        return divID;
    }

    public void setDiv_ID(String divID){
        this.divID=divID;
    }

    public Integer getDiv_ID(){
        return div_ID;
    }

    public void setDivID(Integer div_ID){
        this.div_ID=div_ID;
    }

    public Integer getTeamRank(){
        return teamRank;
    }

    public void setTeamRank(Integer teamRank){
        this.teamRank=teamRank;
    }

    public Integer getGames(){
        return games;
    }

    public void setGames(Integer games){
        this.games=games;
    }

    public Integer getGamesHome(){
        return gamesHome;
    }

    public void setGamesHome(Integer gamesHome){
        this.gamesHome=gamesHome;
    }

    public Integer getWins(){
        return wins;
    }

    public void setWins(Integer wins){
        this.wins=wins;
    }

    public Integer getLosses(){
        return losses;
    }

    public void setLosses(Integer losses){
        this.losses=losses;
    }

    public String getDivisionWinnner(){
        return divisionWinnner;
    }

    public void setDivisionWinnner(String divisionWinnner){
        this.divisionWinnner=divisionWinnner;
    }

    public String getLeagueWinner(){
        return leagueWinner;
    }

    public void setLeagueWinner(String leagueWinner){
        this.leagueWinner=leagueWinner;
    }

    public String getWorldSeriesWinnner(){
        return worldSeriesWinnner;
    }

    public void setWorldSeriesWinnner(String worldSeriesWinnner){
        this.worldSeriesWinnner=worldSeriesWinnner;
    }

    public Integer getRuns(){
        return runs;
    }

    public void setRuns(Integer runs){
        this.runs=runs;
    }

    public Integer getHits(){
        return hits;
    }

    public void setHits(Integer hits){
        this.hits=hits;
    }

    public Integer getHomeruns(){
        return homeruns;
    }

    public void setHomeruns(Integer homeruns){
        this.homeruns=homeruns;
    }

    public Integer getStolenBases(){
        return stolenBases;
    }

    public void setStolenBases(Integer stolenBases){
        this.stolenBases=stolenBases;
    }

    public Integer getHitsAllowed(){
        return hitsAllowed;
    }

    public void setHitsAllowed(Integer hitsAllowed){
        this.hitsAllowed=hitsAllowed;
    }

    public Integer getHomerunsAllowed(){
        return homerunsAllowed;
    }

    public void setHomerunsAllowed(Integer homerunsAllowed){
        this.homerunsAllowed=homerunsAllowed;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPark(){
        return park;
    }

    public void setPark(String park){
        this.park=park;
    }

	@Override
	public int hashCode() {
		return Objects.hash(iD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(iD, other.iD);
	}

	@Override
	public String toString() {
		return teamCode;
	}
    
   
}