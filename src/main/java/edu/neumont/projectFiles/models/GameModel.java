package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by awayman on 5/15/2015.
 */
public class GameModel implements DBSerializable
{
    private String name;
    private String description;
    private long ID;
    //Some kind of routing information to game files / logic will go here in these properties.  I'm not going to assume anything but I'll leave this comment as a reminder.

    public GameModel(){}

    public GameModel(String name, String description){
        this.name = name;
        this.description = description;
    }

    private GameModel(long ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public GameModel(long ID)
    {
        this.ID = ID;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        String name = set.getString("name");
        String description = set.getString("description");
        return new GameModel(id, name, description);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("default, '").append(name).append("', '").append(description).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("(name, description) = ( '").append(name).append("', '").append(description).append("')");
        return sb.toString();
    }
}
