package project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Player;
import project.persistence.entities.Team;
import project.service.TeamService;
import project.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)

    public String createTeamGet(Model model){

        List<String> location = new ArrayList<String>();

        location.add("Home");
        location.add("Away");

        model.addAttribute("locations", location);


        model.addAttribute("createTeam", new Team());

        model.addAttribute("teams",teamService.findAllReverseOrder());

        return "team/Team";
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public String createTeamPost(@ModelAttribute("createTeam") Team team,
                                 Model model) {


        teamService.save(team);

        List<String> location = new ArrayList<String>();

        location.add("Home");
        location.add("Away");

        model.addAttribute("locations", location);

        model.addAttribute("teams", teamService.findAllReverseOrder());

        model.addAttribute("createTeam", new Team());



        return "team/Team";


    }

    @RequestMapping(value = "/team/{teamId}",  method = RequestMethod.GET)
    public String teamGetFromName(@PathVariable Long teamId,
                                    Model model){


        Team team = teamService.findOne(teamId);

        System.out.println(team.getName());

        model.addAttribute("teamName",team.getName());

        model.addAttribute("teamId",teamId);

        System.out.println(teamId);

        return "team/teamView";

    }

}
