package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/18/2015.
 */
public class LogoutPage {

    public static Pattern RegexBOB = Pattern.compile("/bob");
    public static Route getBOB(HttpServletRequest request) {
        return Route.ForwardToUrl("/WEB-INF/logout.jsp");
    }
    public static Route BOBRedirect(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session != null) {
            String username = (String)session.getAttribute("username");
            Long userID = (Long)(session.getAttribute("userID"));
            UserModel user = Singletons.theDAL.retrieveUserModel(userID);
            if( user != null) {
                session.invalidate();
            }
        }
        Route toReturn = Route.RedirectToUrl(request.getContextPath() + "/login");
        return toReturn;
    }
}
