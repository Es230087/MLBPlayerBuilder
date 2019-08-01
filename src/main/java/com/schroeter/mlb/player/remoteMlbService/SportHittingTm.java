package com.schroeter.mlb.player.remoteMlbService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SportHittingTm {
	@JsonProperty("copyRight")
	private String copyRight;
	
	@JsonProperty("queryResults")
	private StatQueryResult statQueryResults;
	
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public StatQueryResult getStatQueryResults() {
		return statQueryResults;
	}
	public void setQueryResults(StatQueryResult statQueryResults) {
		this.statQueryResults = statQueryResults;
	}
}
