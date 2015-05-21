package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bwaite on 5/21/2015.
 */
public class AccountInformationPage {

    public static Pattern Regex = Pattern.compile("/accountInformation/([0-9]+)");

    public static Route getPage(HttpServletRequest request)
    {
        UserModel userM = null;
        Matcher m = Regex.matcher(request.getPathInfo());
        if(m.matches())
        {
            Long userID = 0l;
            try{
            userID = Long.parseLong(m.group(1));
            } catch (Exception e) {}
            userM = Singletons.theDAL.retrieveUserModel(userID);
        }
        return Route.ForwardToUrl("/WEB-INF/accountInformation.jsp",userM);
    }
}
