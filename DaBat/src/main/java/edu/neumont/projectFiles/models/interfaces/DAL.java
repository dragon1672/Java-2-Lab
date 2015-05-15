package edu.neumont.projectFiles.models.interfaces;

import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;

/**
 * Created by bwaite on 5/15/2015.
 */
public interface DAL {
    //region User DAL
    UserModel createUser(UserModel userModel);
    UserModel retrieveUser(int userModelId);
    UserModel updateUser(UserModel userModel);
    void deleteUser(int userModelId);
    //endregion
    //region Achievement DAL
    AchievementModel createAchievementModel(AchievementModel achievementModel);
    AchievementModel retrieveAchievementModel(int gameID, int userId);
    AchievementModel updateAchievementModel(AchievementModel achievementModel);
    void deleteAchievement(int achievementModelId);
    void unlockAchievement(int userID, int achievementModelId);
    //endregion
    //region Game DAL
    GameModel createGameModel(GameModel gameModel);
    GameModel retrieveGameModel(int gameModelId);
    GameModel updateGameModel(GameModel gameModel);
    void deleteGameModel(int gameModelId);
    //endregion
    //region GameScore DAL
    GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel);
    GameScoreModel retrieveGameScoreModel(int gameScoreModelId);
    GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel);
    void deleteGameScore(int gameScoreModelId);
    //endregion
}
