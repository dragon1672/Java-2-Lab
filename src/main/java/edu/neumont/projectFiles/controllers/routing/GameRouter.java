package edu.neumont.projectFiles.controllers.routing;

import edu.neumont.projectFiles.controllers.GamesDisplayPage;
import edu.neumont.projectFiles.controllers.routing.Route;
import utils.CollectionUtils;
import utils.FunctionInterfaces.Functions;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/26/2015.
 */
public class GameRouter {
    public static Pattern Path = Pattern.compile("/game/(\\d+)/(.*)");

    private static class GamePath {
        private Long gameID;
        private Pattern pattern;
        private Functions.Function3<Route,Long,HttpServletRequest,String> function;

        public GamePath(Long gameID, Pattern pattern, Functions.Function3<Route, Long, HttpServletRequest, String> function) {
            this.gameID = gameID;
            this.pattern = pattern;
            this.function = function;
        }

        public Long getGameID() {
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

    public static void AddGamePage(Long gameTypeID,Pattern regex,Functions.Function3<Route,Long,HttpServletRequest,String> function) {
        gamesPages.add(new GamePath(gameTypeID,regex,function));
    }

    private static long ExtractGameIDFromRoom(long roomID) {
        return 1;
    }

    public static Route handleRequest(HttpServletRequest request) {
        Matcher m = Path.matcher(request.getPathInfo());
        if(!m.matches()) throw new RuntimeException("Received improper route to GameRouter");
        long gameID = ExtractGameIDFromRoom(Long.parseLong(m.group(1)));

        Iterable<GamePath> validGames = CollectionUtils.filter(gamesPages,n->n.gameID == gameID);

        GamePath path = CollectionUtils.firstOrDefault(validGames,n->n.pattern.matcher(m.group(2)).matches());

        if(path != null) {
            return path.getFunction().Invoke(gameID,request,m.group(2));
        }
        return null;
    }

}
