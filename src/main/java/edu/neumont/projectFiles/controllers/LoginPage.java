package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/18/2015.
 */
public class LoginPage {
    public static Pattern Regex = Pattern.compile("/login");

    public static Route getPage(HttpServletRequest request) {
        return Route.ForwardToUrl("/WEB-INF/login.jsp");
    }
}
