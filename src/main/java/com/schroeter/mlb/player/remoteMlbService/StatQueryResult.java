package com.schroeter.mlb.player.remoteMlbService;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatQueryResult {
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("totalSize")
	private String totalSize;
	
	@JsonProperty("row")
	private RemotePlayerStats row;
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public RemotePlayerStats getRow() {
		return row;
	}
	public void setRow(RemotePlayerStats row) {
		this.row = row;
	}

}
