package com.schroeter.mlb.player.remoteMlbService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.schroeter.mlb.player.MlbServiceInterface;
import com.schroeter.mlb.player.PlayerResource;

@Service
public class RemoteMlbService implements MlbServiceInterface {
	
	public static final String ROSTER_URL = "http://lookup-service-prod.mlb.com/json/named.roster_40.bam";
	public static final String STATS_URL = "http://lookup-service-prod.mlb.com/json/named.sport_hitting_tm.bam";
	
    @Override
    public PlayerResource getPlayer(String playerId) {
        RestTemplate restTemplate = new RestTemplate();
        String baseURL
                = "http://lookup-service-prod.mlb.com/json/named.player_info.bam?sport_code='mlb'";

        ResponseEntity<String> response
                = restTemplate.getForEntity(baseURL + "&" + "player_id='" + playerId + "'", String.class);
        //Call MLB service
        RemoteMLBPlayerInfoResource remoteResource = new RemoteMLBPlayerInfoResource();

        return null;
    }

	@Override
	public List<PlayerResource> getTeamRoster(String teamId) {
		RestTemplate restTemplate = new RestTemplate();
		
		List<PlayerResource> playerResourceList = new ArrayList();
		
		//get team roster
		ResponseEntity<RemoteMlbRosterResponse> rosterResponse
        = restTemplate.getForEntity(ROSTER_URL + "?" + "team_id='" + teamId + "'", RemoteMlbRosterResponse.class);
		List<RemoteMlbPlayer> remoteRoster = rosterResponse.getBody().getRoster40().getQueryResults().getRow();
		
		playerResourceList.addAll(mapRemoteMlbPlayerToPlayerResource(remoteRoster));		
		
		return playerResourceList;
	}
	
	public List<PlayerResource> getTeamStats(List<PlayerResource> playerResourceList) {
		RestTemplate restTemplate = new RestTemplate();
		
		for (PlayerResource playerResource : playerResourceList) {
			//get player stats
			ResponseEntity<RemoteMlbStatsResponse> response;
			RemotePlayerStats playerStats;
			
			try {
				response = restTemplate.getForEntity(
								STATS_URL + "?" 
								+ "league_list_id='mlb'&game_type='R'&season='2019'" 
								+ "&" + "player_id='" 
								+ playerResource.getPlayerId() 
								+ "'", RemoteMlbStatsResponse.class);
				playerStats = response.getBody().getSportHittingTm().getStatQueryResults().getRow();
				
			} catch ( Exception ex) {
				System.out.println(ex.getMessage());
				
				playerStats = this.createNewStats();
			}
			
			if (playerStats == null) {
				playerStats = this.createNewStats();
			}
			mapRemoteMlbPlayerStatsToPlayerResource(playerResource, playerStats);
		}
		
		return playerResourceList;
	}
	
	private List<PlayerResource> mapRemoteMlbPlayerToPlayerResource(List<RemoteMlbPlayer> remotePlayers) {
		List<PlayerResource> playerResourceList = new ArrayList();
		
		for (RemoteMlbPlayer remotePlayer : remotePlayers) {
			PlayerResource playerResource = new PlayerResource();
			playerResource.setPlayerId(remotePlayer.getPlayerId());
			playerResource.setFirstName(remotePlayer.getNameFirst());
			playerResource.setLastName(remotePlayer.getNameLast());
			playerResource.setPosition(remotePlayer.getPositionTxt());
			playerResource.setBatPosition(remotePlayer.getBats());
			playerResource.setThrowPosition(remotePlayer.getThrowPosition());
			playerResource.setTeamName(remotePlayer.getTeamName());
			playerResourceList.add(playerResource);
		}
		
		return playerResourceList;
	}
	
	private PlayerResource mapRemoteMlbPlayerStatsToPlayerResource(PlayerResource playerResource, RemotePlayerStats playerStats) {
		//map stats
		playerResource.setHomeRuns(Integer.parseInt(playerStats.getHomeRuns()));
		playerResource.setHits(Integer.parseInt(playerStats.getHits()));
		playerResource.setRuns(Integer.parseInt(playerStats.getRuns()));
		playerResource.setAtBats(Integer.parseInt(playerStats.getAtBats()));
		playerResource.setTotalBases(Integer.parseInt(playerStats.getTotalBases()));
		playerResource.setWalks(Integer.parseInt(playerStats.getWalks()));
		playerResource.setStrikeouts(Integer.parseInt(playerStats.getStrikeouts()));
		
		playerResource.setBatAvg(cleanAndParseFloat(playerStats.getBatAvg()));
		playerResource.setSlugPercentage(cleanAndParseFloat(playerStats.getSlugPercentage()));
		playerResource.setOnBasePercentage(cleanAndParseFloat(playerStats.getOnBasePercentage()));
		playerResource.setPitchesPerPlateAppearance(cleanAndParseFloat(playerStats.getPitchesPerPlateAppearance()));
		
		return playerResource;
	}
	
	private RemotePlayerStats createNewStats() {
		RemotePlayerStats playerStats = new RemotePlayerStats();
		playerStats.setAtBats("0");
		playerStats.setBatAvg("0.0");
		playerStats.setHits("0");
		playerStats.setHomeRuns("0");
		playerStats.setOnBasePercentage("0.0");
		playerStats.setPitchesPerPlateAppearance("0.0");
		playerStats.setRuns("0");
		playerStats.setSlugPercentage("0.0");
		playerStats.setStrikeouts("0");
		playerStats.setTotalBases("0");
		playerStats.setWalks("0");
		return playerStats;
	}
	
	private float cleanAndParseFloat(String value) {
		String cleanString = value.replace('-', '0');
		return Float.parseFloat(cleanString);
	}
    
    
}
