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



        // Return the view
        return "player/Player";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/player/{name}", method = RequestMethod.GET)
    public String playerGetFromName(@PathVariable String name,
                                             Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("players", playerService.findByName(name));

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("playerView", new Player());

        // Return the view
        return "player/Player";
    }
}






