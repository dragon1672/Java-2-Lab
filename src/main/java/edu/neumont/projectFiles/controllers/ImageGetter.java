package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 6/2/2015.
 */
public class ImageGetter {
    public static Pattern regex = Pattern.compile("/images/(.*)");

    public static Route handleRequest(HttpServletRequest request) {
        Matcher m = regex.matcher(request.getPathInfo());
        if(!m.matches()) throw new RuntimeException("I got something incorrectly");

        String filePath = m.group(1);
        String routePathToFile = null;
        //TODO: lookup file and forward

        return Route.ForwardToUrl(routePathToFile);
    }
}
