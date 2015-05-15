package edu.neumont.projectFiles.models.interfaces;

/**
 * Created by bwaite on 5/15/2015.
 */
public interface DAL {
    //region User DAL
    User createUser(User user);
    User retrieveUser(int userId);
    User updateUser(User user);
    void deleteUser(int userId);
    //endregion
    //region Achievement DAL
    Achievment createAchievement(Achievement achievement);
    Achievment retrieveAchievement(int gameID, int userId);
    Achievment updateAchievement(Achievement achievement);
    void deleteAchievement(int achievementId);
    void unlockAchievement(int userID, int achievementId);
    //endregion
    //region Game DAL
    GameModel createGameModel(GameModel gameModel);
    GameModel retrieveGameModel(int gameModelId);
    GameModel updateGameModel(GameModel gameModel);
    void deleteGameModel(int gameModelId);
    //endregion
    //region GameScore DAL
    GameScore createGameScore(GameScore gameScore);
    GameScore retrieveGameScore(int gameScoreId);
    GameScore updateGameScore(GameScore gameScore);
    void deleteGameScore(int gameScoreId);
    //endregion
}
