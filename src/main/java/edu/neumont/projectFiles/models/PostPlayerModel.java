package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.models.UserModel;

/**
 * Created by awayman on 5/19/2015.
 */
public class PostPlayerModel
{
    private UserModel thisPlayer;
    private UserModel otherPlayer;

    public enum ResultTypes {WIN, LOSS, DRAW}

    private ResultTypes result;

    public PostPlayerModel(UserModel thisPlayer, UserModel otherPlayer, ResultTypes result)
    {
        this.otherPlayer = otherPlayer;
        this.thisPlayer = thisPlayer;
        this.result = result;
    }

    public UserModel getThisPlayer()
    {
        return thisPlayer;
    }

    public UserModel getOtherPlayer()
    {
        return otherPlayer;
    }

    public ResultTypes getResult()
    {
        return result;
    }
}
