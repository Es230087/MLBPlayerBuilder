package com.schroeter.mlb.player.remoteMlbService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoteMlbRosterResponse {
	
	@JsonProperty("roster_40")
	private Roster40 roster40;

	public Roster40 getRoster40() {
		return roster40;
	}

	public void setRoster40(Roster40 roster40) {
		this.roster40 = roster40;
	}
}
