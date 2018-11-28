package project.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Game;
import project.persistence.entities.Player;
import project.persistence.entities.Users;
import project.service.*;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {

    // Instance Variables
    StringManipulationService stringService;
    private UserService userService;
    private TeamService teamService;
    private PlayerService playerService;
    private GameService gameService;


    // Dependency Injection
    @Autowired
    public EventController(StringManipulationService stringService, UserService userService, TeamService teamService, PlayerService playerService, GameService gameService) {
        this.stringService = stringService;
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.gameService = gameService;
    }


    //
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {


        String action = (String) session.getAttribute("Action");
        Users loggedInUser = (Users) session.getAttribute("login");

        List<Player> playing = (List<Player>) session.getAttribute("playing");
        List<Player> bench = (List<Player>) session.getAttribute("bench");

        Long teamId = (Long) session.getAttribute("teamId");

        if (loggedInUser != null) {


            if (playing.toArray().length < 5 || playing.toArray().length > 5) {
                session.setAttribute("error", "Starting lineup should be 5 \n not less not more, \n only 5");
                return "redirect:/user/pregame/" + teamId;
            }
            model.addAttribute("starters", playing);
            model.addAttribute("players", bench);
            return "Game";
        }
        session.setAttribute("error", "User must be logged in!");
        return "redirect:/login";
    }


    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public void ShotMade(@RequestBody String shotAction) throws JSONException, Exception {


        //-------access the json object ---------//
        JSONObject myObject = new JSONObject(shotAction);



        //-----Add shots -------//
        String playerIdText = myObject.get("playerId").toString();
        if(!playerIdText.equals("")) {
            Long playerId = Long.parseLong(playerIdText);
            String from = myObject.get("from").toString();
            boolean isHit = (boolean) myObject.get("isHit");
            Game shooter = gameService.findByPlayerId(playerId);
            if(isHit) {
                Long shot = Long.parseLong(shooter.getClass().getMethod("get" + from + "Hit").invoke(shooter).toString());
                shooter.getClass().getMethod("set" + from + "Hit", Long.class).invoke(shooter, shot += 1);
            }
            else{
                Long shot = Long.parseLong(shooter.getClass().getMethod("get" + from + "Miss").invoke(shooter).toString());
                shooter.getClass().getMethod("set" + from + "Miss", Long.class).invoke(shooter, shot += 1);
            }
            gameService.save(shooter);
        }




        //-------Add assist------//
        String assistIdText = myObject.get("assist").toString();
        if(!assistIdText.equals("")) {
            Long assistId = Long.parseLong(assistIdText);
            Game assister = gameService.findByPlayerId(assistId);
            Long assist = Long.parseLong(assister.getClass().getMethod("getAssist").invoke(assister).toString());
            assister.getClass().getMethod("setAssist", Long.class).invoke(assister, assist += 1);
            gameService.save(assister);
        }

        //-------Add rebound-------//
        String reboundIdText = myObject.get("rebound").toString();
        System.out.println(reboundIdText);
        if(!reboundIdText.equals("")) {
            Long reboundId = Long.parseLong(reboundIdText);
            Game rebounder = gameService.findByPlayerId(reboundId);
            Long rebound = Long.parseLong(rebounder.getClass().getMethod("getRebound").invoke(rebounder).toString());
            rebounder.getClass().getMethod("setRebound", Long.class).invoke(rebounder, rebound += 1);
            gameService.save(rebounder);
        }


    }

}


