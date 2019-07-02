package com.schroeter.mlb.player;

import java.util.List;

public class PlayerWrapper {
    List<PlayerResource> playerResourceList;



    public PlayerWrapper(List<PlayerResource> playerResourceList) {
        this.playerResourceList = playerResourceList;
    }

    public List<PlayerResource> getPlayerResourceList() {
        return playerResourceList;
    }

    public void setPlayerResourceList(List<PlayerResource> playerResourceList) {
        this.playerResourceList = playerResourceList;
    }



}
