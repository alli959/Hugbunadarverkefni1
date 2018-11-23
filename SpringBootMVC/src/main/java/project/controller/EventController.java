package project.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.StringManipulationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class EventController {
    // Instance Variables
    StringManipulationService stringService;

    // Dependency Injection
    @Autowired
    public EventController(StringManipulationService stringService) {
        this.stringService = stringService;
    }

    //
    @RequestMapping(value = "/Game", method = RequestMethod.GET)
    public String home(){

        return "Game";
    }

    @RequestMapping(value = "/2pt", method = RequestMethod.GET)
    public void twoPT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String player1 = "'Alex'";


        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready(function() {");
        out.println("swal({closeOnClickOutside: false,title: 'Two point shot',buttons: " +
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
        out.println("Offensive: {text: 'Offensive rebound', value: 'offence'}, Defensive: {text: 'Defensive rebound', value: 'defence'}");
        out.println("}");
        out.println("}).then((value) => {");
        out.println("switch (value) {");
        out.println("case 'offence':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Rebound for offence', buttons: {");
        out.println("Player1: {text: "+ player1 + ", value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("console.log(value);");
        out.println("break;");
        out.println("case 'defence':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Rebound for defence', buttons: {");
        out.println("Player1: {text: "+ player1 + ", value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("break;");
        out.println("default:");
        out.println("break;");
        out.println("}");
        out.println("});");
        out.println("default:");
        out.println("break;");
        out.println("}");
        out.println("})");
        out.println("});");
        out.println("</script>");



        RequestDispatcher rd = request.getRequestDispatcher("Game");
        rd.include(request, response);
        //response.sendRedirect("Game");

    }

    @RequestMapping(value = "/3pt", method = RequestMethod.GET)
    public void threePT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String player1 = "'Alex'";

        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready(function() {");
        out.println("swal({closeOnClickOutside: false,title: 'Three point shot',buttons: " +
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
        out.println("Offensive: {text: 'Offensive rebound', value: 'offence'}, Defensive: {text: 'Defensive rebound', value: 'defence'}");
        out.println("}");
        out.println("}).then((value) => {");
        out.println("switch (value) {");
        out.println("case 'offence':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Rebound for offence', buttons: {");
        out.println("Player1: {text: "+ player1 + ", value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("console.log(value);");
        out.println("break;");
        out.println("case 'defence':");
        out.println("swal({closeOnClickOutside: false,");
        out.println("title: 'Rebound for defence', buttons: {");
        out.println("Player1: {text: "+ player1 + ", value: 'player1'}, Player2: {text: 'Player 2', value: 'player2'}");
        out.println("}");
        out.println("});");
        out.println("break;");
        out.println("default:");
        out.println("break;");
        out.println("}");
        out.println("});");
        out.println("default:");
        out.println("break;");
        out.println("}");
        out.println("})");
        out.println("});");
        out.println("</script>");

        RequestDispatcher rd = request.getRequestDispatcher("Game");
        rd.include(request, response);

    }
}
