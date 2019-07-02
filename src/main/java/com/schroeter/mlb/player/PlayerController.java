package com.schroeter.mlb.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(path = "/api/player", method = RequestMethod.GET)
    public PlayerResource player () {
       return playerService.getPlayer();
    }

    @GetMapping(path = "/players")
    public String players (Model modelMap) {
//        modelMap.addAttribute("playerList", playerService.getPlayers());
        PlayerWrapper playerWrapper = new PlayerWrapper(playerService.getPlayers());
//        playerWrapper.setPlayerResourceList(playerService.getPlayers());
        modelMap.addAttribute("form", playerWrapper);
        return "players";
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


}
