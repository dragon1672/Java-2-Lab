package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by tlousignont on 5/22/2015.
 */
public class RoomModel implements DBSerializable {
    private long ID;
    private long gameID;
    private String roomName;
    private Date timePosted;
    private int maxPlayers;
    private int currentNumberOfPlayers;

    private String password;

    private RoomModel(long ID, long gameID, String roomName, Date timePosted, int maxPlayers, int currentNumberOfPlayers) {
        this.ID = ID;
        this.gameID = gameID;
        this.timePosted = timePosted;
        this.maxPlayers = maxPlayers;
        //this.password = password;
        this.roomName = roomName;
        this.currentNumberOfPlayers = currentNumberOfPlayers;
    }

    public RoomModel(long gameID, String roomName, Date timePosted, int maxPlayers, String password) {
        this.gameID = gameID;
        this.timePosted = timePosted;
        this.maxPlayers = maxPlayers;
        this.password = password;
        this.roomName = roomName;
        currentNumberOfPlayers = 1;
    }

    public long getID() {
        return ID;
    }

    public long getGameID() {
        return gameID;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getCurrentNumberOfPlayers()
    {
        return currentNumberOfPlayers;
    }

    public void setCurrentNumberOfPlayers(int currentNumberOfPlayers)
    {
        this.currentNumberOfPlayers = currentNumberOfPlayers;
    }
    public String getPassword() {
        return password;
    }

    public String getRoomName() {
        return roomName;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        long gameId = set.getLong("game_id");
        String name = set.getString("name");
        Date time = set.getTimestamp("time_posted");
        int maxPlayers = set.getInt("max_players");
        int currPlayers = set.getInt("curr_num_players");
        return new RoomModel(id, gameId, name, time, maxPlayers, currPlayers);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(timePosted.getTime());
        sb.append("default, ").append(gameID).append(", '").append(roomName).append(", ")
                .append(timestamp).append(", ").append(maxPlayers).append(", ")
                .append(currentNumberOfPlayers);
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(timePosted.getTime());
        sb.append("(id, game_id, name, time, max_players, curr_num_players) = (").append(ID).append(", ")
            .append(gameID).append(", '").append(roomName).append("', ").append(timestamp).append(", ")
            .append(maxPlayers).append(", ").append(currentNumberOfPlayers).append(")");
        return sb.toString();
    }
}
