package edu.neumont.projectFiles.models;

import java.util.Date;

/**
 * Created by tlousignont on 5/22/2015.
 */
public class RoomModel {
    private long ID;
    private long gameID;
    private String roomName;
    private Date timePosted;
    private int maxPlayers;
    private int currentNumberOfPlayers;

    private String password;

    public RoomModel(long ID, long gameID, String roomName, Date timePosted, int maxPlayers, String password) {
        this.ID = ID;
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
}
