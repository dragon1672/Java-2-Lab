package edu.neumont.projectFiles.tests;

import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.DataBaseDAL;

import java.util.Date;
import java.util.List;

/**
 * Created by dericson on 5/27/2015.
 */
public class DatabaseTests {

    private static DAL dal = new DataBaseDAL();

    public static void main(String[] args){
        testUsers();
    }

    public static void testUsers(){
        /*UserModel model = dal.createUserModel(new UserModel("test", "test2", "username1", "test@test.com", ""));
        List<UserModel> models = dal.getAllUsers();
        models.get(0).setFirstName("Bobby");
        UserModel model = dal.updateUserModel(models.get(0));
        dal.deleteUserModel(2);
        GameModel gameModel = dal.createGameModel(new GameModel("Best Game", "This is the best game."));
        GameModel gameModel2 = dal.createGameModel(new GameModel("Worst Game", "This is the worst game."));
        List<GameModel> gameModels = dal.getAllGames();
        gameModels.get(0).setName("Totally Awesome Game");
        GameModel updatedGameModel = dal.updateGameModel(gameModels.get(0));
        dal.deleteGameModel(gameModels.get(1).getID());
        AchievementModel achievementModel = dal.createAchievementModel(new AchievementModel(1, "Base Achievement", "This is a basic achievement", 50));
        AchievementModel achievementModel2 = dal.createAchievementModel(new AchievementModel(1, "Another Achievement", "This is another basic achievement", 50));
        List<AchievementModel> achievementModels = dal.getAllAchievements();
        achievementModels.get(0).setName("Basic Achievement");
        AchievementModel updatedAchModel = dal.updateAchievementModel(achievementModels.get(0));
        dal.deleteAchievement(achievementModels.get(0).getGameID(), achievementModels.get(0).getID());*/
        GameScoreModel gameScoreModel = dal.createGameScoreModel(new GameScoreModel(1,1,50.0f,new Date()));
        GameScoreModel gameScoreModel2 = dal.createGameScoreModel(new GameScoreModel(1,1,75.0f,new Date()));
        List<GameScoreModel> gameScoreModels = dal.getAllGamesScores();
        dal.deleteGameScore(gameScoreModels.get(0).getGameID(), gameScoreModels.get(0).getID());
    }
}
