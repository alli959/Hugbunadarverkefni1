package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.User;
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
    public String submit(@ModelAttribute("users") User user, Model model) {


        model.addAttribute("users",new User());
        String userName = user.getUserName();
        String password = user.getPassword();
        String name = user.getName(); // Afh er þetta null?
        System.out.println(name);
        List<User> exists = userService.getByUserName(userName);;

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
