package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID the id of the achievement. Primary key in the database.
 * @gameID the id of the game this achievement is related to. Foreign key in the database.
 * @name the name of this achievement.
 * @description a description of this achievement.
 * @points the points this achievement is worth.
 */
public class AchievementModel implements DBSerializable{
    private long ID;
    private long gameID;
    private String name;
    private String description;
    private int points;

    public AchievementModel(){}

    public AchievementModel(long GameID, String name, String description, int points){
        this.gameID = GameID;
        this.name = name;
        this.description = description;
        this.points = points;
    }

    private AchievementModel(long ID, long GameID, String name, String description, int points){
        this.ID = ID;
        this.gameID = GameID;
        this.name = name;
        this.description = description;
        this.points = points;
    }

    public long getID(){
        return ID;
    }

    public long getGameID(){
        return gameID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return points;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        long gameId = set.getLong("game_id");
        String name = set.getString("name");
        String description = set.getString("description");
        int points = set.getInt("points");
        return new AchievementModel(id, gameId, name, description, points);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("default, ").append(gameID).append(", '").append(name).append("', '")
                .append(description).append("', ").append(points);
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("( game_id, name, description, points )=(").append(gameID).append(", '").append(name)
                .append("', '").append(description).append("', ").append(points).append(")");
        return sb.toString();
    }
}
