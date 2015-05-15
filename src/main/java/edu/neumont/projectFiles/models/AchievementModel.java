package edu.neumont.projectFiles.models;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID the id of the achievement. Primary key in the database.
 * @gameID the id of the game this achievement is related to. Foreign key in the database.
 * @name the name of this achievement.
 * @description a description of this achievement.
 * @points the points this achievement is worth.
 */
public class AchievementModel {
    private long ID;
    private long gameID;
    private String name;
    private String description;
    private int points;

    public AchievementModel(long ID, long GameID){
        this.ID = ID;
        this.gameID = gameID;
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

    public void setSescription(String description){
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
}
