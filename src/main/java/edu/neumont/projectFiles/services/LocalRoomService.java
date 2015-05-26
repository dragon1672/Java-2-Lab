package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.RoomModel;

import java.util.Date;
import java.util.List;

/**
 * Created by tlousignont on 5/26/2015.
 */
public class LocalRoomService implements edu.neumont.projectFiles.interfaces.RoomService {

    @Override
    public RoomModel createRoom(String name, long gameID, int numPlayers, String password) {
        RoomModel rm = new RoomModel(-1,gameID,new Date(), numPlayers, password);
        RoomModel newRoom = Singletons.theDAL.createRoomModel(rm);
        return  newRoom;
    }

    @Override
    public RoomModel retrieveRoom(long roomId) {
        return Singletons.theDAL.retrieveRoomModel(roomId);
    }

    @Override
    public RoomModel updateRoom(RoomModel room) {
        return Singletons.theDAL.updateRoomModel(room);
    }

    @Override
    public void deleteRoom(long id) {
        Singletons.theDAL.deleteRoomModel(id);
    }

    @Override
    public List<RoomModel> getAllRooms() {
        return Singletons.theDAL.GetAllRoomModels();
    }
}
