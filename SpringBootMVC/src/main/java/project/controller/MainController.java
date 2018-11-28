package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Game;
import project.persistence.entities.Users;
import project.service.GameService;
import project.service.UserService;
import project.service.PlayerStatsService;
import project.service.TeamService;
import project.persistence.entities.Player;
import project.service.PlayerService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class MainController {
    private UserService userService;
    private TeamService teamService;
    private PlayerService playerService;
    private GameService gameService;
    private PlayerStatsService playerStatsService;


    @Autowired
    public MainController(UserService userService, TeamService teamService, PlayerService playerService, GameService gameService, PlayerStatsService playerStatsService){
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.gameService = gameService;
        this.playerStatsService = playerStatsService;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(HttpSession session, Model model) {
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){
            model.addAttribute("msg", loggedInUser.getName());
            return "main/Main";
        }
        session.setAttribute("error", "User must be logged in!");

        return "redirect:/login";

    }

    @RequestMapping(value = "/user/stats", method = RequestMethod.GET)
    public String teamstats(HttpSession session, Model model) {
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){
            System.out.println(teamService.findAllReverseOrderOwnedByUser(loggedInUser.getUserName()));
            model.addAttribute("teams",teamService.findAllReverseOrderOwnedByUser(loggedInUser.getUserName()));
            return "main/TeamStatView";
        }
        session.setAttribute("error", "User must be logged in!");

        return "redirect:/login";

    }

    @RequestMapping(value = "/user/stats/{teamId}", method = RequestMethod.GET)
    public String stats(HttpSession session, Model model, @PathVariable Long teamId) {
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){
            model.addAttribute("players",playerStatsService.getByTeamId(teamId));
            return "main/StatView";
        }
        session.setAttribute("error", "User must be logged in!");

        return "redirect:/login";

    }





    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model){
        session.removeAttribute("login");
        session.setAttribute("error", "User logged out");

        return "redirect:/login";
    }



    @RequestMapping(value = "/user/pregame", method = RequestMethod.GET)
    public String teamSelect(HttpSession session, Model model){

        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null) {
            model.addAttribute("msg", loggedInUser.getName());

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
        session.setAttribute("error", "User must be logged in!");

        return "redirect:/login";
    }




    @RequestMapping(value = "/user/pregame/{teamId}",  method = RequestMethod.GET)
    public String teamGetFromId(@PathVariable Long teamId,
                                  HttpSession session,
                                  Model model){


        List<Player> players = playerService.findPlayersInTeamReverseOrder(teamId);
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){

            model.addAttribute("msg", loggedInUser.getName());

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
        session.setAttribute("error", "User must be logged in!");

        return "redirect:/login";
    }


    @RequestMapping(value = "/user/pregame/{teamId}/{playerId}",  method = RequestMethod.GET)
    public String playerGetFromId(@PathVariable Long teamId,
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

        session.setAttribute("error", "User must be logged in!");


        return "redirect:/login";

    }







}
