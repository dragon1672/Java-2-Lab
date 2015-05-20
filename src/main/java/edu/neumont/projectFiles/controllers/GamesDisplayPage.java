package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.services.GamesDisplayTestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/20/2015.
 */
public class GamesDisplayPage {
    public static Pattern Regex = Pattern.compile("/games");

    public static Route getPage(HttpServletRequest request) {
        //Get List of Games
        GamesDisplayTestService gdts = new GamesDisplayTestService();
        List<GameModel> games = new ArrayList<>(gdts.dummyGames);
        request.setAttribute("games", games);
        return Route.ForwardToUrl("/WEB-INF/games.jsp");
    }
}
