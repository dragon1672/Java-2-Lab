package edu.neumont.projectFiles.models;

import java.util.Date;

/**
 * Created by tlousignont on 5/22/2015.
 */
public class RoomModel {
    private long ID;
    private long gameID;
    private Date timePosted;
    private int numberOfPlayers;
    private String password;

    public RoomModel(long ID, long gameID, Date timePosted, int numberOfPlayers, String password) {
        this.ID = ID;
        this.gameID = gameID;
        this.timePosted = timePosted;
        this.numberOfPlayers = numberOfPlayers;
        this.password = password;
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

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getPassword() {
        return password;
    }
}
