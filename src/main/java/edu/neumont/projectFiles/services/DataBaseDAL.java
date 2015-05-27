package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DBSerializable;
import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.interfaces.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class DataBaseDAL implements DAL {



    @Override
    public UserModel createUserModel(UserModel userModel) {
        String query = SqlCommandsManager.insertInto("users", userModel);
        DBConnectionManager.runQuery(query);
        DBConnectionManager.runQuery(SqlCommandsManager.getLast("users") );
        return (UserModel)DBConnectionManager.deserialize(UserModel.class);
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        String query = SqlCommandsManager.selectWhereId("users", userModelId);
        DBConnectionManager.runQuery(query );
        UserModel model = new UserModel();
        return (UserModel)DBConnectionManager.deserialize(UserModel.class);
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        String query = SqlCommandsManager.updateWhere("users", userModel.getUpdateSet(), userModel.getID());
        DBConnectionManager.runQuery(query );
        UserModel model = new UserModel();
        return (UserModel) DBConnectionManager.deserialize(UserModel.class);
    }

    @Override
    public void deleteUserModel(long userModelId) {
        String query = SqlCommandsManager.deleteWhereId("users", userModelId);
        DBConnectionManager.runQuery(query );
    }

    @Override
    public List<UserModel> GetAllUsers() {
        String query = SqlCommandsManager.selectAll("users");
        DBConnectionManager.runQuery(query);
        List<UserModel> users = (List<UserModel>) DBConnectionManager.deserializeList(new UserModel());
        return users;
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        String query = SqlCommandsManager.insertInto("games", gameModel);
        DBConnectionManager.runQuery(query );
        DBConnectionManager.runQuery(SqlCommandsManager.getLast("games") );
        return (GameModel)DBConnectionManager.deserialize(GameModel.class);
    }

    @Override
    public GameModel retrieveGameModel(long gameModelId) {
        String query = SqlCommandsManager.selectWhereId("games", gameModelId);
        DBConnectionManager.runQuery(query );
        return (GameModel)DBConnectionManager.deserialize(GameModel.class);
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        String query = SqlCommandsManager.updateWhere("games", gameModel.getUpdateSet(), gameModel.getID());
        DBConnectionManager.runQuery(query );
        return (GameModel) DBConnectionManager.deserialize(GameModel.class);
    }

    @Override
    public void deleteGameModel(long gameModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("games", gameModelId) );
    }

    @Override
    public List<GameModel> GetAllGames() {
        DBConnectionManager.runQuery(SqlCommandsManager.selectAll("games") );
        return (List<GameModel>) DBConnectionManager.deserializeList(new GameModel());
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        DBConnectionManager.runQuery(SqlCommandsManager.insertInto("achievements", achievementModel));
        DBConnectionManager.runQuery(SqlCommandsManager.getLast("achievements"));
        return (AchievementModel) DBConnectionManager.deserialize(achievementModel.getClass());
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameModelId, long achievementModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.selectWhereId("achievements", achievementModelId));
        AchievementModel model = new AchievementModel();
        return (AchievementModel) DBConnectionManager.deserialize(AchievementModel.class);
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        DBConnectionManager.runQuery(SqlCommandsManager.updateWhere("achievements", achievementModel.getUpdateSet(), achievementModel.getID()));
        return (AchievementModel) DBConnectionManager.deserialize(AchievementModel.class);
    }

    @Override
    public void deleteAchievement(long gameModelId, long achievementModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("achievements", achievementModelId));
    }

    @Override
    public void unlockAchievement(long userModelID, long achievementModelId) {

    }

    @Override
    public List<AchievementModel> GetAllAchievements() {
        return null;
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(long gameModelId, long gameScoreModelId) {
        return null;
    }

    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public void deleteGameScore(long gameModelId, long gameScoreModelId) {

    }

    @Override
    public List<GameScoreModel> GetAllGamesScores() {
        return null;
    }
}
