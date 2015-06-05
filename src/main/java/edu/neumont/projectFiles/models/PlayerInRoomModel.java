package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by tlousignont on 6/3/2015.
 */
public class PlayerInRoomModel implements DBSerializable {
    private long roomID;
    private long userID;

    public PlayerInRoomModel(){}

    public PlayerInRoomModel(long roomID, long userID){
        this.roomID = roomID;
        this.userID = userID;
    }

    public long getRoomID() {
        return roomID;
    }

    public long getUserID() {
        return userID;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long playerId = set.getLong("player_id");
        long roomId = set.getLong("room_id");
        return new PlayerInRoomModel(roomId, playerId);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(userID)
                .append(",")
                .append(roomID);
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("(player_id, room_id) = (")
                .append(userID)
                .append(",")
                .append(roomID).append(")");
        return sb.toString();
    }
}
