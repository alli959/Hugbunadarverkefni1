package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Player;
import project.persistence.entities.Team;
import project.service.TeamService;
import project.service.PlayerService;

import java.util.List;


@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    };




    @RequestMapping(value = "/team/{teamId}/player", method = RequestMethod.GET)
    public String playerAddGet(@PathVariable Long teamId,  Model model){


        model.addAttribute("teamId", teamId);

        model.addAttribute("playerAdd",new Player());


        model.addAttribute("playerNo",playerService.countPlayersInTeam(teamId).get(0));


        model.addAttribute("players",playerService.findPlayersInTeamReverseOrder(teamId));

        return "player/Player";
    }



    @RequestMapping(value = "/team/{teamId}/player", method = RequestMethod.POST)
    public String playerAddPost(@ModelAttribute("playerAdd") Player player,
                                @PathVariable Long teamId,
                                     Model model){


        playerService.save(player);
        model.addAttribute("teamId", teamId);


        model.addAttribute("playerNo",playerService.countPlayersInTeam(teamId).get(0));
        model.addAttribute("players",playerService.findPlayersInTeamReverseOrder(teamId));


        model.addAttribute("playerAdd", new Player());




        return "player/Player";
    }




    @RequestMapping(value = "/team/{teamId}/player/{name}", method = RequestMethod.GET)
    public String playerGetFromName(@PathVariable String name,
                                             @PathVariable Long teamId,
                                             Model model){


        model.addAttribute("teamId", teamId);

        model.addAttribute("name",name);


        return "player/playerView";
    }
}






