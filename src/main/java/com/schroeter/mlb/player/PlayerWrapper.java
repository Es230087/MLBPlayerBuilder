package com.schroeter.mlb.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerWrapper {
	
    List<PlayerResource> playerResourceList;

    public PlayerWrapper() {
        this.playerResourceList = new ArrayList();
    }

    public PlayerWrapper(List<PlayerResource> playerResourceList) {
        this.playerResourceList = playerResourceList;
    }

    public List<PlayerResource> getPlayerResourceList() {
        return playerResourceList;
    }

    public void setPlayerResourceList(List<PlayerResource> playerResourceList) {
        this.playerResourceList = playerResourceList;
    }

    public void addPlayerToList(PlayerResource playerResource) {
    	this.playerResourceList.add(playerResource);
    }

}
