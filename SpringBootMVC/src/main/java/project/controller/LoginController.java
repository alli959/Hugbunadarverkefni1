package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.UserService;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService){this.userService = userService;}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("user") User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        List<User> exists = userService.getUserByName(userName);

        if (exists != null && userName != null
                && password != null) {

            model.addAttribute("msg", userName);
            return "success";
        }
                 else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }





}}
