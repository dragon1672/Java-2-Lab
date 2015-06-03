package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/18/2015.
 */
public class LandingPage {
    public static Pattern Regex = Pattern.compile("/");

    public static Route DoIt(HttpServletRequest request) {
        return Route.ForwardToUrl("/WEB-INF/index.jsp");
    }
}
