package edu.neumont.projectFiles.controllers.routing;

import edu.neumont.projectFiles.controllers.GamesDisplayPage;
import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.RoomModel;
import edu.neumont.projectFiles.services.Singletons;
import utils.CollectionUtils;
import utils.FunctionInterfaces.Functions;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/26/2015.
 */
public class GameRouter {
    public static Pattern Path = Pattern.compile("/game/(\\d+)/(.*)");

    private static DAL myDal = Singletons.theDAL;

    private static class GamePath {
        private String gameID;
        private Pattern pattern;
        private Functions.Function3<Route,Long,HttpServletRequest,String> function;

        public GamePath(String gameID, Pattern pattern, Functions.Function3<Route, Long, HttpServletRequest, String> function) {
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

        public Functions.Function3<Route, Long, HttpServletRequest, String> getFunction() {
            return function;
        }
    }

    private static final List<GamePath> gamesPages = new ArrayList<>();

    public static void AddGamePage(String gameTypeID,Pattern regex,Functions.Function3<Route,Long,HttpServletRequest,String> function) {
        gamesPages.add(new GamePath(gameTypeID,regex,function));
    }

    private static String ExtractGameIDFromRoom(long roomID) {
        RoomModel room = myDal.retrieveRoomModel(roomID);
        GameModel game = myDal.retrieveGameModel(room.getGameID());
        return game.getAbbreviation();
    }

    public static Route handleRequest(HttpServletRequest request) {
        Matcher m = Path.matcher(request.getPathInfo());
        if(!m.matches()) throw new RuntimeException("Received improper route to GameRouter");
        long roomID = Long.parseLong(m.group(1));
        String gameID = ExtractGameIDFromRoom(roomID);

        Iterable<GamePath> validGames = CollectionUtils.filter(gamesPages,n-> Objects.equals(n.gameID, gameID));

        GamePath path = CollectionUtils.firstOrDefault(validGames,n->n.pattern.matcher(m.group(2)).matches());

        if(path != null) {
            return path.getFunction().Invoke(roomID,request,m.group(2));
        }
        return null;
    }

}
