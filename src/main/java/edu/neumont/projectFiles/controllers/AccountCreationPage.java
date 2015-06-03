package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.interfaces.AccountService;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        if(avatar.isEmpty()){
            avatar = "http://i.imgur.com/PtGnyUo.jpg";
        }
        //Create an account here
        AccountService las = Singletons.accountService;
        //TODO:password not used yet
         UserModel userM = null;
        if(isValid(accountName) && isValid(firstName) && isValid(lastName)&& isValid(email) && isValid(avatar) && isValid(avatar))
        {
            userM = las.createUser(firstName, lastName, accountName, email, avatar);
            if(userM != null)
            {
                HttpSession session = request.getSession();
                if(session != null) {
                    session.setAttribute("username", userM.getDisplayName());
                    session.setAttribute("userID", userM.getID());
                }
            }
        }

        //Forward page
        return Route.RedirectToUrl(request.getContextPath() +"/accountInformation/" + userM.getID());
    }

    private static boolean isValid(String value)
    {
        return !(value == null || value.isEmpty());
    }
}
