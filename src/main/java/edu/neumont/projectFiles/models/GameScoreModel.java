package edu.neumont.projectFiles.models;
import java.util.Date;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID id of the game score. Primary key in the database.
 * @userID id of the user the game score is related to. Foreign key in the database.
 * @gameID id of the game the game score is related to. Foreign key in the database.
 * @score the score earned in the game.
 * @date the date this game score was created.
 */
public class GameScoreModel {
    private long ID;
    private long userID;
    private long gameID;
    private float score;
    private Date date;

    public GameScoreModel(long ID, long userID, long gameID, float score, Date date){
        this.ID = ID;
        this.userID = userID;
        this.gameID = gameID;
        this.score = score;
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public long getUserID() {
        return userID;
    }

    public long getGameID() {
        return gameID;
    }

    public float getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }
}
