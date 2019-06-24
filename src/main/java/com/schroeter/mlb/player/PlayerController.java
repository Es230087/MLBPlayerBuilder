package com.schroeter.mlb.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(path = "/api/player", method = RequestMethod.GET)
    public PlayerResource player () {
       return playerService.getPlayer();
    }

}
