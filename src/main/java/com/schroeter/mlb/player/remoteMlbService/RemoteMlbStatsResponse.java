package com.schroeter.mlb.player.remoteMlbService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoteMlbStatsResponse {
	
	@JsonProperty("sport_hitting_tm")
	private SportHittingTm sportHittingTm;

	public SportHittingTm getSportHittingTm() {
		return sportHittingTm;
	}

	public void setSportHittingTm(SportHittingTm sportHittingTm) {
		this.sportHittingTm = sportHittingTm;
	}
	
}
