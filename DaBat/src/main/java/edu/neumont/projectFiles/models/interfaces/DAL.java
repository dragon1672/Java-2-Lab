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
    Game createGame(Game game);
    Game retrieveGame(int gameId);
    Game updateGame(Game game);
    void deleteGame(int gameId);
    //endregion
    //region Gamescore DAL
    Gamescore createGame(Gamescore gamescore);
    Gamescore retrieveGame(int gamescoreId);
    Gamescore updateGame(Gamescore gamescore);
    void deleteGame(int gamescoreId);
    //endregion
}
