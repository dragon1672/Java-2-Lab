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
public class LoginPage {
    public static Pattern Regex = Pattern.compile("/login");

    public static Route getPage(HttpServletRequest request) {return Route.ForwardToUrl("/WEB-INF/login.jsp");}
    public static Route LoginUserRedirect(HttpServletRequest request) {
        //login the user here
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserModel userM = null;
        if(username != null && password != null && !username.isEmpty() && !password.isEmpty())
        {
            userM = Singletons.theDAL.retrieveUserModel(username,password);
            if(userM != null)
            {
                HttpSession session = request.getSession();
                   if(session != null) {
                       session.setAttribute("username", userM.getDisplayName());
                       session.setAttribute("userID", userM.getID());
                   }
            }
        }
        return Route.RedirectToUrl(request.getContextPath()+ "/accountInformation/" + userM.getID());
    }
}
