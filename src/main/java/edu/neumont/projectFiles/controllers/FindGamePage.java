package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.PlayerInRoomModel;
import edu.neumont.projectFiles.models.RoomModel;
import edu.neumont.projectFiles.services.LocalPlayersInRoomService;
import edu.neumont.projectFiles.services.LocalRoomService;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tlousignont on 5/27/2015.
 */
public class FindGamePage {

    public static Pattern Regex =  Pattern.compile("/findGame/[0-9]{1,40}");
    public static Pattern regexToJoin = Pattern.compile("/join");

    public static Route getPage(HttpServletRequest request) {
        long gameTypeID = Integer.parseInt(request.getRequestURI().split("/")[3]);
        List<RoomModel> rooms = new ArrayList<>();
        List<RoomModel> allRooms = Singletons.theDAL.getAllRoomModels();
        for (RoomModel room : allRooms){
            if(room.getGameID() == gameTypeID){
                rooms.add(room);
            }
        }
        request.setAttribute("rooms", rooms);
        return Route.ForwardToUrl("/WEB-INF/FindGame.jsp");
    }

    public static Route joinGame(HttpServletRequest request){
        LocalRoomService rs = new LocalRoomService();
        LocalPlayersInRoomService lpirm = new LocalPlayersInRoomService();
        String roomID = request.getParameter("roomID");
        RoomModel room = rs.retrieveRoom(Long.parseLong(roomID));
        request.setAttribute("roomName", room.getRoomName());
        request.setAttribute("gamePassword", room.getPassword());
        int numberOfPlayersInRoom = lpirm.getAllPlayerInRoomModel(room.getID()).size();
        long userId = (long)request.getSession().getAttribute("userID");
        if(room == null){
            return Route.ForwardToUrl("/WEB-INF/404.jsp");
        } else if(numberOfPlayersInRoom <= room.getMaxPlayers()){
            lpirm.createPlayerInRoomModel(room.getID(),userId);
        } else if (lpirm.getAllPlayerInRoomModel(room.getID()).size() >= room.getMaxPlayers()){
            return Route.RedirectToUrl("");
        }
        return Route.RedirectToUrl("/makeGame/"+roomID+"/Wait");
    }
}
