package com.schroeter.mlb.player;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteMlbService implements MlbServiceInterface {
    @Override
    public PlayerResource getPlayer(String playerId) {
//        RestTemplate restTemplate = new RestTemplate();
//        String baseURL
//                = "http://lookup-service-prod.mlb.com/json/named.player_info.bam?sport_code='mlb'";
//
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(baseURL + "&" + "player_id='" + playerId + "'", String.class);
        //Call MLB service
        RemoteMLBPlayerInfoResource remoteResource = new RemoteMLBPlayerInfoResource();

        return null;
    }
}
