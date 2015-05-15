package edu.neumont.projectFiles.models;

/**
 * Created by awayman on 5/15/2015.
 */
public class GameModel
{
    private String name;
    private String description;
    private long ID;
    //Some kind of routing information to game files / logic will go here in these properties.  I'm not going to assume anything but I'll leave this comment as a reminder.


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

    public GameModel(long ID, String name, String description)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }
}
