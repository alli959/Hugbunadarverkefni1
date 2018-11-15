package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Users;
import project.service.UserService;

import java.util.List;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService){this.userService = userService;}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute("users") Users users, Model model) {


        model.addAttribute("users",new Users());
        String userName = users.getUserName();
        String password = users.getPassword();
        //Sækja allar upplýsingar um notandan.
        List<Users> exists = userService.getByUserName(userName);;

        if (exists.size() != 0 && userName != null
                && password != null) {

            model.addAttribute("msg", exists.get(0).getName());
            return "main/Main";
        }
                 else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }





    }
}
