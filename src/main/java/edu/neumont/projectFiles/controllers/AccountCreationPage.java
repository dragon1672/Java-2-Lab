package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.LocalAccountService;

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
        String accountName = request.getParameter("accountName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //Create an account here
        LocalAccountService las = new LocalAccountService();
        las.createUser(firstName,lastName,accountName,email,"");

        //Forward page
        return Route.RedirectToUrl("");
    }
}
