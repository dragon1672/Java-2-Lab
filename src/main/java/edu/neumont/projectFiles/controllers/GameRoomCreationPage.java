package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.PlayerInRoomModel;
import edu.neumont.projectFiles.models.RoomModel;
import edu.neumont.projectFiles.services.LocalPlayersInRoomService;
import edu.neumont.projectFiles.services.LocalRoomService;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.services.Singletons;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/21/2015.
 */
public class GameRoomCreationPage
{
    public static Pattern Regex = Pattern.compile("/makeGame/([0-9]{1,40})");
    public static Pattern CreateGameRegex = Pattern.compile("/makeGame/([0-9]{1,40})/Create");
    public static Pattern WaitingGameRegex = Pattern.compile("/makeGame/([0-9]{1,40})/Wait");

    public static Route getPage(HttpServletRequest request)
    {
        Matcher m = Regex.matcher(request.getPathInfo());
        long gameTypeID = 2;
        if(m.find()){
            gameTypeID = Long.parseLong(m.group(1));
        }
        GameModel gameInformation = Singletons.theDAL.retrieveGameModel(gameTypeID);
        request.setAttribute("GameInfo", gameInformation);
        return Route.ForwardToUrl("/WEB-INF/MakeGame.jsp");
    }

    public static Route createGame(HttpServletRequest request)
    {
        LocalRoomService rs = new LocalRoomService();
        LocalPlayersInRoomService lpirm = new LocalPlayersInRoomService();
        String roomName = request.getParameter("roomName");
        String password = request.getParameter("gamePassword");
        long gameId = 1;
        Matcher m = CreateGameRegex.matcher(request.getPathInfo());
        if(m.find()){
            gameId = Long.parseLong(m.group(1));
        }
        String numPlayers = request.getParameter("numPlayers");
        RoomModel rm = rs.createRoom(roomName, gameId, Integer.parseInt(numPlayers), password);
        if(request.getSession().getAttribute("userID") == null){
            return Route.ForwardToUrl("/WEB-INF/404.jsp");
        }
        PlayerInRoomModel pirm = lpirm.createPlayerInRoomModel(rm.getID(), (long)request.getSession().getAttribute("userID"));
        String URLtoRedirect = "/makeGame/"+rm.getID()+"/Wait";
        return Route.RedirectToUrl(URLtoRedirect);
    }

    public static Route isGameReady(HttpServletRequest request)
    {
        LocalRoomService rs = new LocalRoomService();
        LocalPlayersInRoomService lpirm = new LocalPlayersInRoomService();
        String roomName = request.getParameter("roomName");
        String password = request.getParameter("gamePassword");
        long roomId = 1;
        Matcher m = WaitingGameRegex.matcher(request.getPathInfo());
        if(m.find()){
            roomId = Long.parseLong(m.group(1));
        }
        String numPlayers = request.getParameter("numPlayers");
        RoomModel temp = rs.retrieveRoom(roomId);
        if(temp != null){
            List<PlayerInRoomModel> test = lpirm.getAllPlayerInRoomModel(temp.getID());
            test = null;
        }
        if (temp == null)
        {
            return Route.ForwardToUrl("/WEB-INF/404.jsp");
        }
        else
        if (lpirm.getAllPlayerInRoomModel(temp.getID()).size() == temp.getMaxPlayers())
        {
            //HEY, THIS NEEDS TO REDIRECT TO THE INDIVIDUAL GAME
            return Route.RedirectToUrl("/games/" +temp.getID());
        }
        else
        {
            return Route.ForwardToUrl("/WEB-INF/WaitingForPlayers.jsp");
        }
    }
}
