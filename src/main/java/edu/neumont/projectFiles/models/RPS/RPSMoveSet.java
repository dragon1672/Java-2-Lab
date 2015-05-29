package edu.neumont.projectFiles.models.RPS;
import utils.CollectionUtils;
import java.util.*;
import static edu.neumont.projectFiles.models.RPS.RPSMove.*;
/**
 * Created by Anthony on 3/24/2015.
 */
public class RPSMoveSet {
    //region static things

    public static class MoveBeatsMove {
        public final String beatMsg;
        RPSMove Who, Them;

        public MoveBeatsMove(RPSMove who, String beatMsg, RPSMove them) {
            Who = who;
            this.beatMsg = beatMsg;
            Them = them;
        }

        public String message() {
            return String.format("%s %s %s", Who, beatMsg, Them);
        }
    }

    public static final RPSMoveSet ClassicRockPaperScissors = new RPSMoveSet(
            new MoveBeatsMove(Scissors, "cut", Paper),
            new MoveBeatsMove(Paper, "covers", Rock),
            new MoveBeatsMove(Rock, "crushes", Scissors)
    );
    public static final RPSMoveSet RockPaperScissorsLizardSpockSpiderManWizardGlockBatman = new RPSMoveSet(
            new MoveBeatsMove(Scissors, "cuts", Paper),
            new MoveBeatsMove(Paper, "covers", Rock),
            new MoveBeatsMove(Rock, "crushes", Lizard),
            new MoveBeatsMove(Lizard, "poisons", Spock),
            new MoveBeatsMove(Spock, "zaps", Wizard),
            new MoveBeatsMove(Wizard, "stuns", Batman),
            new MoveBeatsMove(Batman, "scares", Spiderman),
            new MoveBeatsMove(Spiderman, "disarms", Glock),
            new MoveBeatsMove(Glock, "breaks", Rock),
            new MoveBeatsMove(Rock, "interrupts", Wizard),
            new MoveBeatsMove(Wizard, "burns", Paper),
            new MoveBeatsMove(Paper, "disproves", Spock),
            new MoveBeatsMove(Spock, "befuddles", Spiderman),
            new MoveBeatsMove(Spiderman, "defeats", Lizard),
            new MoveBeatsMove(Lizard, "looks like Killer Croc and confuses", Batman),
            new MoveBeatsMove(Batman, "dismantles", Scissors),
            new MoveBeatsMove(Scissors, "cut", Wizard),
            new MoveBeatsMove(Wizard, "transforms", Lizard),
            new MoveBeatsMove(Lizard, "eats", Paper),
            new MoveBeatsMove(Paper, "jams", Glock),
            new MoveBeatsMove(Glock, "kills the mother of", Batman),
            new MoveBeatsMove(Batman, "explodes", Rock),
            new MoveBeatsMove(Rock, "crushes", Scissors),
            new MoveBeatsMove(Scissors, "decapitates", Lizard),
            new MoveBeatsMove(Lizard, "is too small for", Glock),
            new MoveBeatsMove(Glock, "shoots", Spock),
            new MoveBeatsMove(Spock, "vaporizes", Rock),
            new MoveBeatsMove(Rock, "knocks out", Spiderman),
            new MoveBeatsMove(Spiderman, "rips", Paper),
            new MoveBeatsMove(Paper, "delays", Batman),
            new MoveBeatsMove(Batman, "hangs", Spock),
            new MoveBeatsMove(Spock, "smashes", Scissors),
            new MoveBeatsMove(Scissors, "cut", Spiderman),
            new MoveBeatsMove(Spiderman, "annoys", Wizard),
            new MoveBeatsMove(Wizard, "melts", Glock),
            new MoveBeatsMove(Glock, "dents", Scissors)
    );
    public static final RPSMoveSet RockPaperScissorsLizardSpock = new RPSMoveSet(
            new MoveBeatsMove(Scissors, "cut", Paper),
            new MoveBeatsMove(Paper, "covers", Rock),
            new MoveBeatsMove(Rock, "crushes", Scissors),
            new MoveBeatsMove(Rock, "crushes", Lizard),
            new MoveBeatsMove(Lizard, "poisons", Spock),
            new MoveBeatsMove(Spock, "smashes", Scissors),
            new MoveBeatsMove(Scissors, "decapitates", Lizard),
            new MoveBeatsMove(Lizard, "eats", Paper),
            new MoveBeatsMove(Paper, "disproves", Spock),
            new MoveBeatsMove(Spock, "vaporizes", Rock)
    );

    //endregion

    private Set<RPSMove> acceptedMoves = new HashSet<>();
    private List<MoveBeatsMove> moveList = new ArrayList<>();

    public RPSMoveSet(MoveBeatsMove... moveSet) {
        Collections.addAll(moveList, moveSet);
        for (MoveBeatsMove m : moveSet) {
            acceptedMoves.add(m.Who);
            acceptedMoves.add(m.Them);
        }
    }

    public MoveResponse getResponse(RPSMove P1, RPSMove P2) {
        if (!acceptedMoves.contains(P1) || !acceptedMoves.contains(P2)) throw new RuntimeException("poop");

        int winner = 0; // default to tie
        MoveBeatsMove moveData = CollectionUtils.firstOrDefault(moveList, a -> a.Who.equals(P1) && a.Them.equals(P2));
        if (moveData != null) { // did P1 win?
            winner = 1;
        }
        if (moveData == null) { // did P1 not win?
            moveData = CollectionUtils.firstOrDefault(moveList, a -> a.Who.equals(P2) && a.Them.equals(P1));
            if (moveData != null) { // did P2 win?
                winner = -1;
            } // else no one won
        }


        return new MoveResponse(winner, moveData, P1, P2);
    }

    public boolean invalidMove(RPSMove p1Move) {
        return !acceptedMoves.contains(p1Move);
    }
}
