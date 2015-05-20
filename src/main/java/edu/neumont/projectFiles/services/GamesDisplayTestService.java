package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.models.GameModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlousignont on 5/20/2015.
 */
public class GamesDisplayTestService {
    public List<GameModel> dummyGames = new ArrayList<GameModel>();
    public GamesDisplayTestService(){
        GameModel temp1 = new GameModel(1,"Da Bomb", "This is da bomb. Do not click");
        dummyGames.add(temp1);
        GameModel temp2 = new GameModel(2,"test game Please ignore", "This is a test game please ignore");
        dummyGames.add(temp2);
        GameModel temp3 = new GameModel(3,"The best game", "out of order");
        dummyGames.add(temp3);
        GameModel temp4 = new GameModel(4,"Shhhh", "What Game?");
        dummyGames.add(temp4);
    }
}
