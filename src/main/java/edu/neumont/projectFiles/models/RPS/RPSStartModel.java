package edu.neumont.projectFiles.models.RPS;

import edu.neumont.projectFiles.models.UserModel;

/**
 * Created by bwaite on 6/2/2015.
 */
public class RPSStartModel {
    UserModel currentPlayer, otherPlayer;

    public RPSStartModel(UserModel currentPlayer, UserModel otherPlayer) {
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer.getDisplayName();
    }

    public String getOtherPlayer() {
        return otherPlayer.getDisplayName();
    }
}
