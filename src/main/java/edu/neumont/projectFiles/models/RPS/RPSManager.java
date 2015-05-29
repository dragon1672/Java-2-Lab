package edu.neumont.projectFiles.models.RPS;
import edu.neumont.projectFiles.models.UserModel;
import utils.Tuple;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by bwaite on 5/27/2015.
 */
public class RPSManager{

    public class RPSUser {
        private UserModel user;
        private int index;
        private boolean readyToStartNewGame;
        private RPSMove lastSavedMove;
        private boolean doneWithGame;

        public RPSUser(UserModel user) {
            this.user = user;
            this.index = 0;
            this.doneWithGame = false;
            this.readyToStartNewGame = true;
        }

        public UserModel getUser() {
            return user;
        }

        public int getIndex() {
            return index;
        }

        public boolean isDoneWithGame() {
            return doneWithGame;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setDoneWithGame(boolean doneWithGame) {
            this.doneWithGame = doneWithGame;
        }

        public RPSMove getLastSavedMove() {
            return lastSavedMove;
        }

        public void setLastSavedMove(RPSMove lastSavedMove) {
            this.lastSavedMove = lastSavedMove;
        }

        public boolean isReadyToStartNewGame() {
            return readyToStartNewGame;
        }

        public void setReadyToStartNewGame(boolean readyToStartNewGame) {
            this.readyToStartNewGame = readyToStartNewGame;
        }
    }

    private RPSUser p1,p2;
    //First = use p1 index, //Second = p2 index
    private List<Tuple<RPSMove,RPSMove>> Moves = new ArrayList<>();

    public RPSUser getP1() {
        return p1;
    }

    public void setP1(UserModel user) {
        this.p1 = new RPSUser(user);
    }

    public RPSUser getP2() {
        return p2;
    }

    public void setP2(UserModel user) {
        this.p2 = new RPSUser(user);
    }

    public List<Tuple<RPSMove, RPSMove>> getMoves() {
        return Moves;
    }

    public void addMove(Tuple<RPSMove, RPSMove> move) {
        p1.setLastSavedMove(move.getFirst());
        p2.setLastSavedMove(move.getSecond());
        this.Moves.add(move);
    }
}