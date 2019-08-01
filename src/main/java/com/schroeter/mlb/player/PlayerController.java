package com.schroeter.mlb.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@SessionAttributes("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(path = "/players")
    public String players (
    		Model modelMap, 
    		@ModelAttribute("players") PlayerWrapper playerWrapper) {
    	
    	// add players from session attribute to model 
        if (!playerWrapper.getPlayerResourceList().isEmpty()) {
        	modelMap.addAttribute("chosenPlayers", playerWrapper);
        }
        
        // add players from viewing team to model
        TeamBeingViewed teamBeingViewed = new TeamBeingViewed("Some Team", playerService.getTeamRoster("121"));
        
        modelMap.addAttribute("teamBeingViewed", teamBeingViewed);
        
        return "players";
    }
    
    @GetMapping(path = "/players/{teamId}")
    public String playersWithChosenTeam (
    		Model modelMap, 
    		@ModelAttribute("players") PlayerWrapper playerWrapper,
    		@PathVariable("teamId") String teamId) {
    	
    	// add players from session attribute to model 
        if (!playerWrapper.getPlayerResourceList().isEmpty()) {
        	modelMap.addAttribute("chosenPlayers", playerWrapper);
        }
        
        // add players from viewing team to model
        TeamBeingViewed teamBeingViewed = new TeamBeingViewed("Some Team", playerService.getTeamRoster(teamId));
        
        modelMap.addAttribute("teamBeingViewed", teamBeingViewed);
        
        return "players";
    }
    
    
    @RequestMapping(path = "/addPlayers", method = RequestMethod.POST)
    public RedirectView addPlayersToList (
    		@ModelAttribute TeamBeingViewed players, 
    		@ModelAttribute("players") PlayerWrapper playerWrapper, 
    		RedirectAttributes attributes) throws IOException {
    	
    	for (PlayerResource player : players.getPlayersOnTeam()) {
    		if(player.chosen) {
    			playerWrapper.addPlayerToList(player);
    		}
    	}

    	attributes.addFlashAttribute("form", playerWrapper);
    	
    	return new RedirectView("/players");
    }

    @RequestMapping(path = "/playerxls", method = RequestMethod.POST)
    public HttpEntity<byte[]> exportPlayersXls (@ModelAttribute PlayerWrapper players, Model model) throws IOException {
//    public HttpEntity<byte[]> exportPlayersXls (@RequestBody List<PlayerResource> players) throws IOException {
        /** assume that below line gives you file content in byte array **/
        byte[] excelContent = playerService.createPlayerXls(players.getPlayerResourceList());
        // prepare response
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_team.xls");
        header.setContentLength(excelContent.length);

        return new HttpEntity<byte[]>(excelContent, header);
    }
    
    @ModelAttribute("players")
    public PlayerWrapper players() {
        return new PlayerWrapper();
    }
    
    @InitBinder("players")
	public void configureBindingOfPlayers(WebDataBinder binder) {
	    binder.setAllowedFields(); // No fields allowed
	}

}
