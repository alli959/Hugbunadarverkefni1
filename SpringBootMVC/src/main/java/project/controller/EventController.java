package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Game;
import project.persistence.entities.Player;
import project.persistence.entities.Users;
import project.service.PlayerService;
import project.service.StringManipulationService;
import project.service.TeamService;
import project.service.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    // Instance Variables
    StringManipulationService stringService;
    private UserService userService;
    private TeamService teamService;
    private PlayerService playerService;



    // Dependency Injection
    @Autowired
    public EventController(StringManipulationService stringService, UserService userService, TeamService teamService, PlayerService playerService ) {
        this.stringService = stringService;
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
    }


    //
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String home(HttpSession session, Model model){


        String action = (String)session.getAttribute("Action");
        Users loggedInUser = (Users)session.getAttribute("login");

        List<Player> playing = (List<Player>) session.getAttribute("playing");
        List<Player> bench = (List<Player>) session.getAttribute("bench");

        Long teamId = (Long) session.getAttribute("teamId");

        if(loggedInUser != null) {


            if(playing.toArray().length < 5 || playing.toArray().length > 5) {
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
    public void action(@RequestBody String test){
        System.out.println(test);
    }



    @RequestMapping(value = "/leftwingthree", method = RequestMethod.GET)
    public String LeftWingThree(HttpSession session){
        session.setAttribute("Action","leftwingthree");
        return "redirect:/game";
    }



    @RequestMapping(value = "/rightwingthree", method = RequestMethod.GET)
    public String RightWingThree(HttpSession session){
        session.setAttribute("Action","rightwingthree");
        return "redirect:/game";
    }


    @RequestMapping(value = "/topthree", method = RequestMethod.GET)
    public String TopThree(HttpSession session){
        session.setAttribute("Action","topthree");
        return "redirect:/game";
    }


    @RequestMapping(value = "/leftcornerthree", method = RequestMethod.GET)
    public String LeftCornerThree(HttpSession session){
        session.setAttribute("Action","leftcornerthree");
        return "redirect:/game";
    }


    @RequestMapping(value = "/rightcornerthree", method = RequestMethod.GET)
    public String RightCornerThree(HttpSession session){
        session.setAttribute("Action","rightcornerthree");
        return "redirect:/game";
    }


    @RequestMapping(value = "/leftshortcorner", method = RequestMethod.GET)
    public String LeftShortCorner(HttpSession session){
        session.setAttribute("Action","leftshortcorner");
        return "redirect:/game";
    }


    @RequestMapping(value = "/rightshortcorner", method = RequestMethod.GET)
    public String RightShortCorner(HttpSession session){
        session.setAttribute("Action","rightshortcorner");
        return "redirect:/game";
    }


    @RequestMapping(value = "/lefttopkey", method = RequestMethod.GET)
    public String LeftTopKey(HttpSession session){
        session.setAttribute("Action","lefttopkey");
        return "redirect:/game";
    }


    @RequestMapping(value = "/righttopkey", method = RequestMethod.GET)
    public String RightTopKey(HttpSession session){
        session.setAttribute("Action","righttopkey");
        return "redirect:/game";
    }


    @RequestMapping(value = "/topkey", method = RequestMethod.GET)
    public String TopKey(HttpSession session){
        session.setAttribute("Action","topkey");
        return "redirect:/game";
    }


    @RequestMapping(value = "/layup", method = RequestMethod.GET)
    public String LayUp(HttpSession session){
        session.setAttribute("Action","layup");
        return "redirect:/game";
    }



    /*@RequestMapping(value = "/alert", method = RequestMethod.GET)
    public void alert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String player1 = "'Alex'";

        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready(function() {");
        out.println("swal({closeOnClickOutside: false,title: 'Shot',buttons: " +
                "{Made: {" +
                "text: 'Made', value: 'made' }, " +
                "Miss: {" +
                "text: 'Miss', value: 'miss'}");
        out.println("}}).then((value) => {");
        out.println("switch (value) {");
        out.println("case 'made':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Assist', buttons: {");
        out.println("Player1: {text: "+ player1 + ", value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("console.log(value);");
        out.println("break;");
        out.println("case 'miss':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Rebound', buttons: {");
        out.println("Player1: {text: 'Player 1', value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("");
        out.println("default:");
        out.println("break;");
        out.println("}");
        out.println("})");
        out.println("});");
        out.println("</script>");

        RequestDispatcher rd = request.getRequestDispatcher("game");
        rd.include(request, response);

    }*/
}
