package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.services.GamesDisplayTestService;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/20/2015.
 */
public class GamesDisplayPage {
    private static GamesDisplayTestService gdts = new GamesDisplayTestService();

    public static Pattern Regex = Pattern.compile("/games");

    public static Route getPage(HttpServletRequest request) {
        //Get List of Games
        List<GameModel> games = Singletons.theDAL.GetAllGames();
        request.setAttribute("games", games);
        return Route.ForwardToUrl("/WEB-INF/games.jsp");
    }
}
