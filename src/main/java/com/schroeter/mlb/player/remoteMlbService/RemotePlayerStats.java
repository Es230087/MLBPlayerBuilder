package com.schroeter.mlb.player.remoteMlbService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemotePlayerStats {
	
	@JsonProperty("hr")
	private String homeRuns;
	
	@JsonProperty("h")
	private String hits;
	
	@JsonProperty("r")
	private String runs;
	
	@JsonProperty("ab")
	private String atBats;
	
	@JsonProperty("tb")
	private String totalBases;
	
	@JsonProperty("bb")
	private String walks;
	
	@JsonProperty("so")
	private String strikeouts;
	
	@JsonProperty("avg")
	private String batAvg;
	
	@JsonProperty("slg")
	private String slugPercentage;
	
	@JsonProperty("obp")
	private String onBasePercentage;
	
	@JsonProperty("ppa")
	private String pitchesPerPlateAppearance;

	public String getHomeRuns() {
		return homeRuns;
	}

	public void setHomeRuns(String homeRuns) {
		this.homeRuns = homeRuns;
	}

	public String getHits() {
		return hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getRuns() {
		return runs;
	}

	public void setRuns(String runs) {
		this.runs = runs;
	}

	public String getAtBats() {
		return atBats;
	}

	public void setAtBats(String atBats) {
		this.atBats = atBats;
	}

	public String getTotalBases() {
		return totalBases;
	}

	public void setTotalBases(String totalBases) {
		this.totalBases = totalBases;
	}

	public String getWalks() {
		return walks;
	}

	public void setWalks(String walks) {
		this.walks = walks;
	}

	public String getStrikeouts() {
		return strikeouts;
	}

	public void setStrikeouts(String strikeouts) {
		this.strikeouts = strikeouts;
	}

	public String getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(String batAvg) {
		this.batAvg = batAvg;
	}

	public String getSlugPercentage() {
		return slugPercentage;
	}

	public void setSlugPercentage(String slugPercentage) {
		this.slugPercentage = slugPercentage;
	}

	public String getOnBasePercentage() {
		return onBasePercentage;
	}

	public void setOnBasePercentage(String onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}

	public String getPitchesPerPlateAppearance() {
		return pitchesPerPlateAppearance;
	}

	public void setPitchesPerPlateAppearance(String pitchesPerPlateAppearance) {
		this.pitchesPerPlateAppearance = pitchesPerPlateAppearance;
	}
	
}
