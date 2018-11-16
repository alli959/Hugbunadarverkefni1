package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Users;
import project.service.UserService;

import javax.servlet.http.HttpSession;
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
    public String submit(@ModelAttribute("users") Users users, HttpSession session, Model model) {

        
        model.addAttribute("users",new Users());
        String userName = users.getUserName();
        String password = users.getPassword();
        String name = users.getName(); // Afh er þetta null?
        System.out.println(name);
        Users exists = userService.getByUserName(userName);

        System.out.println(exists == null);


        if (exists != null && userName != null
                && password != null) {

            session.setAttribute("login", exists);
            model.addAttribute("msg", exists.getName());
            return "redirect:/user";
        }
                 else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }





    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(HttpSession session, Model model) {
        Users loggedInUser = (Users)session.getAttribute("login");
        if(loggedInUser != null){
            return "main/Main";
        }
        return "redirect:/login";

    }
}
