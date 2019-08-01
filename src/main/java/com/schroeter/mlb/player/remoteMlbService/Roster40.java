package com.schroeter.mlb.player.remoteMlbService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Roster40 {
	
	@JsonProperty("copyRight")
	private String copyRight;
	
	@JsonProperty("queryResults")
	private QueryResult queryResults;
	
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public QueryResult getQueryResults() {
		return queryResults;
	}
	public void setQueryResults(QueryResult queryResults) {
		this.queryResults = queryResults;
	}
}
