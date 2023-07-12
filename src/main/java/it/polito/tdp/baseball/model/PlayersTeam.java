package it.polito.tdp.baseball.model;

import java.util.Objects;

public class PlayersTeam {

	private String PlayerID;
	private int teamID;
	
	public PlayersTeam(String playerID, int teamID) {
		PlayerID = playerID;
		this.teamID = teamID;
	}

	public String getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(String playerID) {
		PlayerID = playerID;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PlayerID, teamID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayersTeam other = (PlayersTeam) obj;
		return Objects.equals(PlayerID, other.PlayerID) && teamID == other.teamID;
	}

}