package edu.neumont.projectFiles.models.RPS;

import edu.neumont.projectFiles.models.UserModel;

/**
 * Created by bwaite on 6/2/2015.
 */
public class RPSResultsModel {
    UserModel P1,P2;
            RPSMove P1Choice,P2Choice,WinChoice,LoseChoice;
             String BeatStatement,WinChoicePicPath,LostChoicePicPath,WonOrLost;

    public RPSResultsModel(RPSManager rpsGame, MoveResponse moveResponse, boolean userIsPlayer1) {
        P1 = rpsGame.getP1().getUser();
        P2 = rpsGame.getP2().getUser();
        P1Choice = rpsGame.getCurrentMove().getFirst();
        P2Choice = rpsGame.getCurrentMove().getSecond();
        BeatStatement = moveResponse.moveData.beatMsg;

        WonOrLost = "Won";
        if(moveResponse.Tie()){
            BeatStatement = "ties with";
            WonOrLost = "Tied";
            WinChoice  = rpsGame.getCurrentMove().getFirst() ;
            LoseChoice = rpsGame.getCurrentMove().getSecond();
        } else if(moveResponse.P1Won()) {
            if(!userIsPlayer1) {
                WonOrLost = "Lost";
            }
            WinChoice  = rpsGame.getCurrentMove().getFirst() ;
            LoseChoice = rpsGame.getCurrentMove().getSecond();
        } else if(moveResponse.P2Won()){
            if(userIsPlayer1){
                WonOrLost = "Lost";
            }
            WinChoice  = rpsGame.getCurrentMove().getSecond();
            LoseChoice = rpsGame.getCurrentMove().getFirst();
        }

        WinChoicePicPath = getRPSPic(WinChoice);
        LostChoicePicPath = getRPSPic(LoseChoice);

    }

    private String getRPSPic(RPSMove move){
        String picturePath = "";
       if(move.equals(RPSMove.Rock)){

       } else if(move.equals(RPSMove.Scissors)){

       } else if (move.equals(RPSMove.Paper)){

       }

        return picturePath;
    }

    public String getP1() {
        return P1.getDisplayName();
    }

    public String getP2() {
        return P2.getDisplayName();
    }

    public String getP1Choice() {
        return P1Choice.getText();
    }

    public String getP2Choice() {
        return P2Choice.getText();
    }

    public String getWinChoice() {
        return WinChoice.getText();
    }

    public String getLoseChoice() {
        return LoseChoice.getText();
    }

    public String getBeatStatement() {
        return BeatStatement;
    }

    public String getWinChoicePicPath() {
        return WinChoicePicPath;
    }

    public String getLostChoicePicPath() {
        return LostChoicePicPath;
    }

    public String getWonOrLost() {
        return WonOrLost;
    }
}
