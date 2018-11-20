package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Users;
import project.service.UserService;
import project.persistence.entities.Team;
import project.service.TeamService;
import project.persistence.entities.Player;
import project.service.PlayerService;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller

public class MainController {
    private UserService userService;
    private TeamService teamService;
    private PlayerService playerService;


    @Autowired
    public MainController(UserService userService, TeamService teamService, PlayerService playerService){
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(HttpSession session, Model model) {
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){
            model.addAttribute("msg", loggedInUser.getName());
            return "main/Main";
        }
        return "redirect:/login";

    }



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model){
        session.removeAttribute("login");
        return "redirect:/login";
    }



    @RequestMapping(value = "/user/pregame", method = RequestMethod.GET)
    public String teamSelect(HttpSession session, Model model){
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null) {
            model.addAttribute("teams",teamService.findAllReverseOrderOwnedByUser(loggedInUser.getUserName()));
            return "preGame/teamSelect";
        }
        return "redirect:/login";
    }




    @RequestMapping(value = "/user/pregame/{teamId}",  method = RequestMethod.GET)
    public String teamGetFromName(@PathVariable Long teamId,
                                  HttpSession session,
                                  Model model){

        Users loggedInUser = (Users)session.getAttribute("login");
        List<Player> starters = (List<Player>)session.getAttribute("starters");
        if(loggedInUser != null) {
            if((List<Player>)session.getAttribute("bench") == null){

                List<Player> bench = playerService.findPlayersInTeamReverseOrder(teamId);
                session.setAttribute("bench", bench);
                Team team = teamService.findOne(teamId);

                if(!team.getUserOwner().equals(loggedInUser.getUserName())){
                    model.addAttribute("Message","Team not owned by User");
                    return "Error";
                }


                model.addAttribute("players", bench);
                model.addAttribute("starters",starters);

                return "preGame/startingLineup";
            }


            List<Player> bench = (List<Player>)session.getAttribute("bench");
            Team team = teamService.findOne(teamId);

            if(!team.getUserOwner().equals(loggedInUser.getUserName())){
                model.addAttribute("Message","Team not owned by User");
                return "Error";
            }


            model.addAttribute("players", bench);
            model.addAttribute("starters",starters);

            return "preGame/startingLineup";



        }

        return "redirect:/login";

    }


    @RequestMapping(value = "/user/pregame/{teamId}/{playerId}",  method = RequestMethod.GET)
    public String teamGetFromName(@PathVariable Long teamId,
                                  @PathVariable Long playerId,
                                  HttpSession session,
                                  Model model){

        Users loggedInUser = (Users)session.getAttribute("login");
        List<Player> bench = (List<Player>)session.getAttribute("bench");
        if(loggedInUser != null) {


            if((List<Player>)session.getAttribute("starters") == null){
                List<Player> starters = new ArrayList<>();
                Player starter = playerService.findOne(playerId);
                starters.add(starter);
                bench.remove(starter);
                System.out.println(starter);
                session.setAttribute("bench",bench);
                session.setAttribute("starters",starters);
                return "redirect:/user/pregame/{teamId}";
            }


            List<Player> starters = (List<Player>)session.getAttribute("starters");
            Player starter = playerService.findOne(playerId);
            starters.add(starter);
            bench.remove(starter);
            session.setAttribute("bench",bench);
            session.setAttribute("starters",starters);
            return "redirect:/user/pregame/{teamId}";

        }
        return "redirect:/login";

    }


}
