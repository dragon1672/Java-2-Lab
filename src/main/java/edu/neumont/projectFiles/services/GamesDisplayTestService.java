package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.models.GameModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlousignont on 5/20/2015.
 */
public class GamesDisplayTestService {
    private List<GameModel> dummyGames = new ArrayList<GameModel>();
    public GamesDisplayTestService(){
        LocalGameService LGS = new LocalGameService();
        LGS.createGame("Da Bomb", "This is da bomb. Do not click");
        LGS.createGame("test game Please ignore", "This is a test game please ignore");
        LGS.createGame("The best game", "out of order");
        LGS.createGame("Shhhh", "What Game?");
    }

}
