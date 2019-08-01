package com.schroeter.mlb.player;

import java.util.List;

public class TeamBeingViewed {
	private String TeamName;
	private List<PlayerResource> playersOnTeam;
	
	public TeamBeingViewed(String teamName, List<PlayerResource> playerResourceList) {
		this.TeamName = teamName;
		this.playersOnTeam = playerResourceList;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public List<PlayerResource> getPlayersOnTeam() {
		return playersOnTeam;
	}

	public void setPlayersOnTeam(List<PlayerResource> playerResourceList) {
		this.playersOnTeam = playerResourceList;
	}
	
	
}
