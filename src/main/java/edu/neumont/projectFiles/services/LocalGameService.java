package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.GameService;
import edu.neumont.projectFiles.models.GameModel;

/**
 * Created by bwaite on 5/20/2015.
 */
public class LocalGameService  implements GameService{
    @Override
    public GameModel createGame(String name, String description) {
        return null;
    }

    @Override
    public GameModel retrieveGame(long id) {
        return null;
    }

    @Override
    public GameModel updateGame(GameModel user) {
        return null;
    }

    @Override
    public void deleteGame(long id) {

    }
}
