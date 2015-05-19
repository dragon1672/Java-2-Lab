package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/19/2015.
 */
public class AccountCreationPage {
    public static Pattern Regex = Pattern.compile("/accountCreation");

    public static Route getPage(HttpServletRequest request) {
        return Route.ForwardToUrl("/WEB-INF/accountCreation.jsp");
    }

    public static Route createAccountRedirect(HttpServletRequest request){
        //Information to create an account
        String AccountName = request.getParameter("accountName");
        String FirstName = request.getParameter("firstName");
        String LastName = request.getParameter("lastName");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        //Create an account here

        //Forward page
        return Route.RedirectToUrl("");
    }
}
