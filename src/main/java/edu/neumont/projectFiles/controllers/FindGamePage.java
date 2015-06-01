package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.RoomModel;
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
}
