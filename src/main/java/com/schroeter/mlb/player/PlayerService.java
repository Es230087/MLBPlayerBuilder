package com.schroeter.mlb.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private RemoteMlbService remoteMlbService;

    public PlayerResource getPlayer() {
        //Call MLB player info service
        PlayerResource playerResource = remoteMlbService.getPlayer("493316");
        //call MLB player stat service

        // map to playerResource
//        PlayerResource playerResource = new PlayerResource();
//        playerResource.setFirstName("Carl");
//        playerResource.setLastName("Smith");
        return playerResource;
    }
}
