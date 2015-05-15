package edu.neumont.projectFiles.models.interfaces;

/**
 * Created by bwaite on 5/15/2015.
 */
public interface DAL {
    //region User DAL
    public User createUser(User user);
    public User retrieveUser(int userId);
    public User updateUser(User user);
    public void deleteUser(int userId);
    //endregion
    //region Achievment DAL
    public Achievment createAchievment(Achievment achievment);
    public Achievment retrieveAchievment(int gameID, int userId);
    public Achievment updateAchievment(Achievment achievment);
    public void deleteAchievment(int achievmentId);
    public void unlockAchievment(int userID, int achievmentId);
    //endregion
    //region Game DAL
    public Game createGame(Game game);
    public Game retrieveGame(int gameId);
    public Game updateGame(Game game);
    public void deleteGame(int gameId);
    //endregion
    //region Gamescore DAL
    public Gamescore createGame(Gamescore gamescore);
    public Gamescore retrieveGame(int gamescoreId);
    public Gamescore updateGame(Gamescore gamescore);
    public void deleteGame(int gamescoreId);
    //endregion
}
