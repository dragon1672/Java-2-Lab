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
    public final RPSMove P1Move, P2Move;

    public MoveResponse(int compare, RPSMoveSet.MoveBeatsMove moveData, RPSMove P1, RPSMove P2) {
        this.compare = compare;
        this.moveData = moveData;
        P1Move = P1;
        P2Move = P2;
    }
    public boolean P1Won()  { return compare  > 0; }
    public boolean P2Won() { return compare  < 0; }
    public boolean Tie()   { return compare == 0; }
}