package edu.neumont.projectFiles.models;
import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID id of the game score. Primary key in the database.
 * @userID id of the user the game score is related to. Foreign key in the database.
 * @gameID id of the game the game score is related to. Foreign key in the database.
 * @score the score earned in the game.
 * @date the date this game score was created.
 */
public class GameScoreModel implements DBSerializable {
    private long ID;
    private long userID;
    private long gameID;
    private float score;
    private Date date;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    public GameScoreModel(){}

    public GameScoreModel(long userID, long gameID, float score, Date date){
        this.userID = userID;
        this.gameID = gameID;
        this.score = score;
        this.date = date;
    }

    private GameScoreModel(long ID, long userID, long gameID, float score, Date date){
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

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        long userId = set.getLong("user_id");
        long gameId = set.getLong("game_id");
        float score = set.getFloat("score");
        Date date = set.getTimestamp("timestamp");
        return new GameScoreModel(id, userId, gameId, score, date);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        sb.append("default, ").append(userID).append(", ").append(gameID).append(", ")
                .append(score).append(", '").append(timestamp).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("(user_id, game_id, score, timestamp)=(").append(userID).append(", ")
                .append(gameID).append(", ").append(score).append(", ").append(date).append(")");
        return sb.toString();
    }
}
