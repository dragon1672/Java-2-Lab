package edu.neumont.projectFiles.controllers.routing;

import edu.neumont.projectFiles.controllers.RPS.RockPaperScissorsPage;
import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.RoomModel;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;
import utils.CollectionIterator;
import utils.FunctionInterfaces.Functions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/26/2015.
 */
public class GameRouter {
    private static final List<GamePath> gamesPages = new ArrayList<>();

    static { // register games here
        AddGamePage("RPS", RockPaperScissorsPage.Regex,RockPaperScissorsPage::getPage);
    }

    public static Pattern Path = Pattern.compile("/games/(\\d+)(/.*)?");

    private static DAL myDal = Singletons.theDAL;

    private static class GamePath {
        private String gameID;
        private Pattern pattern;
        private Functions.Function4<Route, Long, HttpServletRequest, String, UserModel> function;

        public GamePath(String gameID, Pattern pattern, Functions.Function4<Route, Long, HttpServletRequest, String, UserModel> function) {
            this.gameID = gameID;
            this.pattern = pattern;
            this.function = function;
        }

        public String getGameID() {
            return gameID;
        }

        public Pattern getPattern() {
            return pattern;
        }

        public Functions.Function4<Route, Long, HttpServletRequest, String, UserModel> getFunction() {
            return function;
        }
    }

    public static void AddGamePage(String gameTypeID, Pattern regex, Functions.Function4<Route, Long, HttpServletRequest, String, UserModel> function) {
        gamesPages.add(new GamePath(gameTypeID, regex, function));
    }

    public static Route handleRequest(HttpServletRequest request) {
        Matcher m = Path.matcher(request.getPathInfo());
        if (!m.matches()) throw new RuntimeException("Received improper route to GameRouter");

        long roomID = Long.parseLong(m.group(1));
        String gameAbbreviation = "RPS";
        try {
            RoomModel room = myDal.retrieveRoomModel(roomID);
            GameModel game = myDal.retrieveGameModel(room.getGameID());
            gameAbbreviation = game.getAbbreviation();
        } catch (Exception e) {
            //means that the room is invalid, fix when database is legit
        }

        //region make sure user is legit

        HttpSession session = request.getSession();
        if (session == null) return Route.ForwardToUrl("/login");
        Long userID = (Long) session.getAttribute("userID");
        if (userID == null) return Route.ForwardToUrl("/login");
        UserModel userM = Singletons.theDAL.retrieveUserModel(userID);
        if (userM == null) throw new RuntimeException("User not valid");

        //TODO: make sure user is legit for game

        //endregion

        String gamePath = m.group(2) != null ? m.group(2) : "/";

        final String finalGameAbbreviation = gameAbbreviation;
        GamePath path = CollectionIterator.convert(gamesPages).filter(n -> Objects.equals(n.getGameID(), finalGameAbbreviation)).firstOrDefault(n -> {
            return n.pattern.matcher(gamePath).matches();
        });

        if (path != null) {
            return path.getFunction().Invoke(roomID, request, m.group(2), userM);
        }
        return null;
    }

}
