package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Player;
import project.persistence.entities.Team;
import project.persistence.entities.Users;
import project.service.TeamService;
import project.service.PlayerService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    };




    @RequestMapping(value = "/user/team/{teamId}/player", method = RequestMethod.GET)
    public String playerAddGet(@PathVariable Long teamId, HttpSession session, Model model){

        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null) {

            model.addAttribute("msg",loggedInUser.getName());
            model.addAttribute("teamId", teamId);

            model.addAttribute("playerAdd", new Player());


            model.addAttribute("playerNo", playerService.countPlayersInTeam(teamId).get(0));


            model.addAttribute("players", playerService.findPlayersInTeamReverseOrder(teamId));

            return "player/Player";
        }
        return "redirect:/login";
    }



    @RequestMapping(value = "/user/team/{teamId}/player", method = RequestMethod.POST)
    public String playerAddPost(@ModelAttribute("playerAdd") Player player,
                                HttpSession session,
                                @PathVariable Long teamId,
                                     Model model){

        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null) {
            playerService.save(player);
            model.addAttribute("msg", loggedInUser.getName());

            model.addAttribute("teamId", teamId);


            model.addAttribute("playerNo", playerService.countPlayersInTeam(teamId).get(0));
            model.addAttribute("players", playerService.findPlayersInTeamReverseOrder(teamId));


            model.addAttribute("playerAdd", new Player());


            return "player/Player";
        }
        return "redirect:/login";
    }




    @RequestMapping(value = "/user/team/{teamId}/player/{playerId}", method = RequestMethod.GET)
    public String playerGetFromName(@PathVariable Long playerId,
                                             @PathVariable Long teamId,
                                             HttpSession session,
                                             Model model){


        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null) {
            model.addAttribute("msg", loggedInUser.getName());
            model.addAttribute("teamId", teamId);

            model.addAttribute("playerId", playerId);


            return "player/playerView";
        }
        return "redirect:/login";
    }
}






