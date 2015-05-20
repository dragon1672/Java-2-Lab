package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.GameService;
import edu.neumont.projectFiles.models.GameModel;

import java.util.List;

/**
 * Created by bwaite on 5/20/2015.
 */
public class LocalGameService  implements GameService{
    @Override
    public GameModel createGame(String name, String description) {
       name = validateInput(name,"name");
        description = validateInput(description, "description");
        //use -1 for id, Database will assign ID later.
        GameModel gameM = new GameModel(-1,name,description);
        Singletons.theDAL.createGameModel(gameM);
        return gameM;
    }

    @Override
    public GameModel retrieveGame(long id) {
        return Singletons.theDAL.retrieveGameModel(id);
    }

    @Override
    public GameModel updateGame(GameModel game) {
        GameModel gameInDB = Singletons.theDAL.retrieveGameModel(game.getID());
        GameModel gameNew = null;
        if(gameInDB != null)
        {
            gameNew = new GameModel(game.getID(),
                    validateInput(game.getName(),"name"),
                    validateInput(game.getDescription(), "description"));
            Singletons.theDAL.updateGameModel(gameNew);
        }
        return gameNew;
    }

    @Override
    public void deleteGame(long id) {
        Singletons.theDAL.deleteGameModel(id);
    }

    @Override
    public List<GameModel> getAllGames() {
        return Singletons.theDAL.GetAllGames();
    }
}
