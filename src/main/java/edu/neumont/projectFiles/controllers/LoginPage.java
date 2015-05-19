package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/18/2015.
 */
public class LoginPage {
    public static Pattern Regex = Pattern.compile("/login");

    public static Route getLoginPage(HttpServletRequest request) {return Route.ForwardToUrl("/WEB-INF/login.jsp");}
    public static Route LoginUserRedirect(HttpServletRequest request) {
        //login the user here
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //currently redirect to home page
        return Route.RedirectToUrl("");}
}
