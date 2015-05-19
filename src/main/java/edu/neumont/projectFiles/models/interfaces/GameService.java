package edu.neumont.projectFiles.models.interfaces;

import edu.neumont.projectFiles.models.GameModel;

/**
 * Created by bwaite on 5/19/2015.
 */
public interface GameService {
    GameModel createGame(String name, String description);
    GameModel retrieveGame(String name);
    GameModel retrieveGame(long id);
    GameModel updateGame(GameModel user);
    void deleteGame(long id);
}
