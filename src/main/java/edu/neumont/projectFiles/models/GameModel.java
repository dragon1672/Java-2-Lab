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
    private String abbreviation;
    //Some kind of routing information to game files / logic will go here in these properties.  I'm not going to assume anything but I'll leave this comment as a reminder.

    public GameModel(){}
    
    /*private GameModel(long ID, String name, String description, String abbreviation) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
    }*/
    
    public GameModel(long ID, String name, String description, String abbreviation) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        String name = set.getString("name");
        String description = set.getString("description");
        String abbreviation = set.getString("abbrev");
        return new GameModel(id, name, description, abbreviation);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        name = name.replaceAll("'", "''");
        description = description.replaceAll("'", "''");
        sb.append("default, '").append(name).append("', '").append(description).append("', '")
            .append(abbreviation).append("'");
        return sb.toString();
    }

    @Override
    public String getUpdateSet() {
        StringBuilder sb = new StringBuilder();
        name = name.replaceAll("'", "''");
        description = description.replaceAll("'", "''");
        sb.append("(name, description, abbrev) = ( '").append(name).append("', '").append(description).append("', '")
            .append(abbreviation).append("')");
        return sb.toString();
    }
}
