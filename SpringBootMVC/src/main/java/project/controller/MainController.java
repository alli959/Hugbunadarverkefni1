package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Game;
import project.persistence.entities.Users;
import project.service.GameService;
import project.service.UserService;
import project.persistence.entities.Team;
import project.service.TeamService;
import project.persistence.entities.Player;
import project.service.PlayerService;

import javax.print.DocFlavor;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller

public class MainController {
    private UserService userService;
    private TeamService teamService;
    private PlayerService playerService;
    private GameService gameService;


    @Autowired
    public MainController(UserService userService, TeamService teamService, PlayerService playerService, GameService gameService){
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.gameService = gameService;
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
            List<Game> game = gameService.findAllReverseOrder();
            if(game.toArray().length != 0){
                for(int i = 0; i<game.size(); i++){
                    Game aGame = game.get(i);
                    gameService.delete(aGame);
                }
            }
            return "preGame/teamSelect";
        }
        return "redirect:/login";
    }




    @RequestMapping(value = "/user/pregame/{teamId}",  method = RequestMethod.GET)
    public String teamGetFromName(@PathVariable Long teamId,
                                  HttpSession session,
                                  Model model){


        List<Player> players = playerService.findPlayersInTeamReverseOrder(teamId);
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){


            if(gameService.findAllReverseOrder().toArray().length <= 0){
                for(int i = 0; i<players.size(); i++) {
                    Game player = new Game();
                    player.setBench(true);
                    player.setPlayerId(players.get(i).getId());
                    gameService.save(player);
                }

            }




            List<Game> bench = gameService.getBench();
            List<Game> playing = gameService.getPlaying();

            List<Player> initBench = new ArrayList<>();
            List<Player> initPlaying = new ArrayList<>();


            // Ugly for loops to add bench or playing

            for(int i = 0; i<bench.size(); i++){
                initBench.add(playerService.findOne(bench.get(i).getPlayerId()));
            }

            for(int i = 0; i<playing.size(); i++){
                initPlaying.add(playerService.findOne(playing.get(i).getPlayerId()));
            }

            model.addAttribute("players",initBench);
            model.addAttribute("starters",initPlaying);
            model.addAttribute("error",session.getAttribute("error"));
            session.removeAttribute("error");
            session.setAttribute("playing",initPlaying);
            session.setAttribute("bench",initBench);
            session.setAttribute("teamId", teamId);

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
        Game player = gameService.findByPlayerId(playerId);

        if(loggedInUser != null) {

            player.setBench(!player.isBench());
            gameService.save(player);



            return "redirect:/user/pregame/{teamId}";
        }


        return "redirect:/login";

    }







}
