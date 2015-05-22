package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * Created by bwaite on 5/22/2015.
 */
public class RockPaperScissorsPage {
    public static Pattern Regex = Pattern.compile("/RPS");

    public static Route getPage(HttpServletRequest request)
    {
        Route toReturn = Route.ForwardToUrl("");
        String username = "";
        Long userID = null;
        HttpSession session = request.getSession();
        if(session != null) {
            username = (String)session.getAttribute("username");
            userID = (Long)session.getAttribute("userID");
        }
        if(userID != null) {
            UserModel userM = Singletons.theDAL.retrieveUserModel(userID);
            String choice = request.getParameter("choice");
            if (userM != null) {
                if(choice == null || choice.isEmpty()) {
                    toReturn = Route.ForwardToUrl("/WEB-INF/RPSstart.jsp");
                } else {
                    toReturn = Route.ForwardToUrl("/WEB-INF/RPSresults.jsp", choice);
                }
            }
        }
        return toReturn;
    }
}
