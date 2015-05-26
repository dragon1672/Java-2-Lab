package edu.neumont.projectFiles.controllers.routing.games.rps.models;

/**
 * Created by Anthony on 3/24/2015.
 */
public class MoveResponse {
    /**
     * +1: win
     * -1: lose
     *  0: tie
     */
    public final int compare;
    public final RPSMoveSet.MoveBeatsMove moveData;
    public final RPSMove MyMove,TheirMove;

    public MoveResponse(int compare, RPSMoveSet.MoveBeatsMove moveData, RPSMove myMove, RPSMove theirMove) {
        this.compare = compare;
        this.moveData = moveData;
        MyMove = myMove;
        TheirMove = theirMove;
    }
    public boolean IWon()  { return compare  > 0; }
    public boolean ILost() { return compare  < 0; }
    public boolean Tie()   { return compare == 0; }
}