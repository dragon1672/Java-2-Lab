package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/21/2015.
 */
public class GameRoomCreationPage {
    public static Pattern Regex = Pattern.compile("/makeGame/[0-9]{1,40}");
    public static Pattern CreateGameRegex = Pattern.compile("/makeGame/[0-9]{1,40}/Create");

    public static Route getPage(HttpServletRequest request) {
        long gameTypeID = 0;//Integer.parseInt(request.getRequestURI().split("/")[1]);
        GameModel gameInformation = Singletons.theDAL.retrieveGameModel(gameTypeID);
        request.setAttribute("GameInfo", gameInformation);
        return Route.ForwardToUrl("/WEB-INF/MakeGame.jsp");
    }

    public static Route createGame(HttpServletRequest request) {
        return Route.ForwardToUrl("/WEB-INF/index.jsp");
    }
}
