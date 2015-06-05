package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.PlayersInRoomsService;
import edu.neumont.projectFiles.models.PlayerInRoomModel;

import java.util.List;

/**
 * Created by tlousignont on 6/3/2015.
 */
public class LocalPlayersInRoomService implements PlayersInRoomsService{

    @Override
    public PlayerInRoomModel createPlayerInRoomModel(long roomId, long playerId) {
        PlayerInRoomModel pirm = new PlayerInRoomModel(roomId,playerId);
        Singletons.theDAL.createPlayerInRoomModel(pirm);
        return Singletons.theDAL.retrievePlayerInRoomModel(pirm.getRoomID(),pirm.getUserID());
    }

    @Override
    public PlayerInRoomModel retrievePlayerInRoomModel(long roomId, long playerId) {
        return Singletons.theDAL.retrievePlayerInRoomModel(roomId, playerId);
    }

    @Override
    public PlayerInRoomModel updatePlayerInRoomModel(PlayerInRoomModel pirm) {
        Singletons.theDAL.deletePlayerInRoomModel(pirm.getRoomID(),pirm.getUserID());
        return createPlayerInRoomModel(pirm.getRoomID(),pirm.getUserID());
    }

    @Override
    public void deletePlayerInRoomModel(long roomId, long playerId) {
        Singletons.theDAL.deletePlayerInRoomModel(roomId,playerId);
    }

    @Override
    public List<PlayerInRoomModel> getAllPlayerInRoomModel(long roomId) {
        return Singletons.theDAL.getAllPlayerInRoomModels(roomId);
    }
}
