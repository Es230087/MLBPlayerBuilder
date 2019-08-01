package com.schroeter.mlb.player;

import java.util.List;

public interface MlbServiceInterface {

    public PlayerResource getPlayer(String playerId);
    
    public List<PlayerResource> getTeamRoster(String teamId);

}
