package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by awayman on 6/2/2015.
 */
public class RemoveSWF404Page
{
    public static Pattern Regex = Pattern.compile("/removeSWF");

    public static Route getPage(HttpServletRequest request)
    {
        Singletons.theDAL.removeSWFURL(request.getParameter("URLtoRemove"));
        return Route.ForwardToUrl("/WEB-INF/404.jsp");
    }


}
