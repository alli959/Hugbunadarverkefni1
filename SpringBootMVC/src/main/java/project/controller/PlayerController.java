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


    @RequestMapping(value = "/team/player",  method = RequestMethod.GET)
    public String playerViewGet(@PathVariable Long id, Model model){

        model.addAttribute("playerView",new Player());


        if(playerService.findLargestId().toArray().length == 0){
            model.addAttribute("playerNo",0);
        }
        else {
            model.addAttribute("playerNo", playerService.findLargestId().get(0));
        }


        model.addAttribute("players",playerService.findAllReverseOrder());

        return "player/Player";
    }
    @RequestMapping(value = "/team/player",  method = RequestMethod.POST)
    public String playerViewPost(@ModelAttribute("playerView") Player player,
                                 @PathVariable Long id,
                                     Model model){


        playerService.save(player);

        model.addAttribute("players", playerService.findAllReverseOrder());

        model.addAttribute("playerNo",playerService.findLargestId().get(0));

        model.addAttribute("playerView", new Player());




        return "player/Player";
    }


    @RequestMapping(value = "/team/player/{name}",  method = RequestMethod.GET)
    public String playerGetFromName(@PathVariable String name,
                                    @PathVariable Long id,
                                             Model model){


        model.addAttribute("players", playerService.findByName(name));


        model.addAttribute("playerView", new Player());


        return "player/Player";
    }
}






