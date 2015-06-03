package edu.neumont.projectFiles.models.RPS;

import edu.neumont.projectFiles.models.UserModel;

/**
 * Created by bwaite on 6/2/2015.
 */
public class RPSResultsModel {
    UserModel P1,P2;
            RPSMove P1Choice,P2Choice,WinChoice,LoseChoice;
             String BeatStatement,WinChoicePicPath,LoseChoicePicPath,WonOrLost;

    public RPSResultsModel(RPSManager rpsGame, MoveResponse moveResponse, boolean userIsPlayer1) {
        P1 = rpsGame.getP1().getUser();
        P2 = rpsGame.getP2().getUser();
        P1Choice = rpsGame.getCurrentMove().getFirst();
        P2Choice = rpsGame.getCurrentMove().getSecond();
        BeatStatement = "ties with";
        if(moveResponse!= null && moveResponse.moveData!=null && moveResponse.moveData.beatMsg != null) {
            BeatStatement = moveResponse.moveData.beatMsg;
        }

        WonOrLost = "Won";
        if(moveResponse.Tie()){
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
        LoseChoicePicPath = getRPSPic(LoseChoice);

    }

    private String getRPSPic(RPSMove move){
        String picturePath = "";
       if(move.equals(RPSMove.Rock)){
        picturePath ="http://upload.wikimedia.org/wikipedia/commons/7/7e/Rock-paper-scissors_(rock).png";
       } else if(move.equals(RPSMove.Scissors)){
        picturePath = "http://upload.wikimedia.org/wikipedia/commons/5/5f/Rock-paper-scissors_(scissors).png";
       } else if (move.equals(RPSMove.Paper)){
        picturePath= "http://upload.wikimedia.org/wikipedia/commons/a/af/Rock-paper-scissors_(paper).png";
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

    public String getLoseChoicePicPath() {
        return LoseChoicePicPath;
    }

    public String getWonOrLost() {
        return WonOrLost;
    }
}
