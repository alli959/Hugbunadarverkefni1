package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Player;
import project.service.PlayerService;

import java.util.List;


@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
        System.out.println(playerService);
    };


    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String playerViewGet(Model model){

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
    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public String playerViewPost(@ModelAttribute("playerView") Player player,
                                     Model model){


        playerService.save(player);


        model.addAttribute("players", playerService.findAllReverseOrder());

        model.addAttribute("playerNo",playerService.findLargestId().get(0));

        model.addAttribute("playerView", new Player());




        return "player/Player";
    }


    @RequestMapping(value = "/player/{name}", method = RequestMethod.GET)
    public String playerGetFromName(@PathVariable String name,
                                             Model model){


        model.addAttribute("players", playerService.findByName(name));


        model.addAttribute("playerView", new Player());


        return "player/Player";
    }
}






