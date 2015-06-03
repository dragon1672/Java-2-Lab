package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.models.*;
import edu.neumont.projectFiles.interfaces.DAL;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class DataBaseDAL implements DAL {

    @Override
    public UserModel createUserModel(UserModel userModel) {
        UserModel model = null;
        if(userModel != null) {
            String query = SqlCommandsManager.insertInto("users", userModel);
            DBConnectionManager.runQuery(query);
            DBConnectionManager.runQuery(SqlCommandsManager.getLast("users"));
            model = (UserModel) DBConnectionManager.deserialize(UserModel.class);
        }
        return model;
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        String query = SqlCommandsManager.selectWhereId("users", userModelId);
        DBConnectionManager.runQuery(query );
        UserModel model = new UserModel();
        return (UserModel)DBConnectionManager.deserialize(UserModel.class);
    }

    @Override
    public UserModel retrieveUserModel(String username, String password) {
        StringBuilder query = SqlCommandsManager.selectWhere("users");
        query.append(" display_name = '").append(username).append("' and password = '").append(password).append("';");
        DBConnectionManager.runQuery(query.toString());
        return (UserModel) DBConnectionManager.deserialize(UserModel.class);
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        UserModel model = null;
        if(userModel != null) {
            String query = SqlCommandsManager.updateWhere("users", userModel.getUpdateSet(), userModel.getID());
            DBConnectionManager.runQuery(query);
            model =  (UserModel) DBConnectionManager.deserialize(UserModel.class);
        }
        return model;
    }

    @Override
    public void deleteUserModel(long userModelId) {
        String query = SqlCommandsManager.deleteWhereId("users", userModelId);
        DBConnectionManager.runQuery(query, false);
    }

    @Override
    public List<UserModel> getAllUsers() {
        String query = SqlCommandsManager.selectAll("users");
        DBConnectionManager.runQuery(query);
        List<UserModel> users = (List<UserModel>) DBConnectionManager.deserializeList(UserModel.class);
        return users;
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        GameModel model = null;
        if(gameModel != null) {
            String query = SqlCommandsManager.insertInto("games", gameModel);
            DBConnectionManager.runQuery(query);
            DBConnectionManager.runQuery(SqlCommandsManager.getLast("games"));
            model =  (GameModel) DBConnectionManager.deserialize(GameModel.class);
        }
        return model;
    }

    @Override
    public GameModel retrieveGameModel(long gameModelId) {
        String query = SqlCommandsManager.selectWhereId("games", gameModelId);
        DBConnectionManager.runQuery(query );
        return (GameModel)DBConnectionManager.deserialize(GameModel.class);
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        GameModel model = null ;
        if(gameModel != null) {
            String query = SqlCommandsManager.updateWhere("games", gameModel.getUpdateSet(), gameModel.getID());
            DBConnectionManager.runQuery(query);
            model = (GameModel) DBConnectionManager.deserialize(GameModel.class);
        }
        return model;
    }

    @Override
    public void deleteGameModel(long gameModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("games", gameModelId), false );
    }

    @Override
    public List<GameModel> getAllGames() {
        DBConnectionManager.runQuery(SqlCommandsManager.selectAll("games") );
        return (List<GameModel>) DBConnectionManager.deserializeList(GameModel.class);
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        AchievementModel model = null;
        if(achievementModel != null) {
            DBConnectionManager.runQuery(SqlCommandsManager.insertInto("achievements", achievementModel));
            DBConnectionManager.runQuery(SqlCommandsManager.getLast("achievements"));
            model = (AchievementModel) DBConnectionManager.deserialize(achievementModel.getClass());
        }
        return model;
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameModelId, long achievementModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.selectWhereId("achievements", achievementModelId));
        AchievementModel model = new AchievementModel();
        return (AchievementModel) DBConnectionManager.deserialize(AchievementModel.class);
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        AchievementModel model = null;
        if(achievementModel != null) {
            DBConnectionManager.runQuery(SqlCommandsManager.updateWhere("achievements", achievementModel.getUpdateSet(), achievementModel.getID()));
            model = (AchievementModel) DBConnectionManager.deserialize(AchievementModel.class);
        }
        return model;
    }

    @Override
    public void deleteAchievement(long gameModelId, long achievementModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("achievements", achievementModelId), false);
    }

    @Override
    public void unlockAchievement(long userModelID, long achievementModelId) {
        StringBuilder sb = SqlCommandsManager.insert("userAchievements");
        sb.append(userModelID).append(", ").append(achievementModelId).append(") returning *;");
        DBConnectionManager.runQuery(sb.toString());
    }

    @Override
    public List<AchievementModel> getAllAchievements() {
        DBConnectionManager.runQuery(SqlCommandsManager.selectAll("achievements"));
        return (List<AchievementModel>) DBConnectionManager.deserializeList(AchievementModel.class);
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        DBConnectionManager.runQuery(SqlCommandsManager.insertInto("gameScores", gameScoreModel));
        return (GameScoreModel) DBConnectionManager.deserialize(GameScoreModel.class);
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(long gameModelId, long gameScoreModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.selectWhereId("gameScores", gameScoreModelId));
        return (GameScoreModel) DBConnectionManager.deserialize(GameScoreModel.class);
    }

    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        GameScoreModel model = null;
        if(gameScoreModel != null) {
            DBConnectionManager.runQuery(SqlCommandsManager.updateWhere("gameScores", gameScoreModel.getUpdateSet(), gameScoreModel.getID()));
            model = (GameScoreModel) DBConnectionManager.deserialize(GameScoreModel.class);
        }
        return model;
    }

    @Override
    public void deleteGameScore(long gameModelId, long gameScoreModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("gameScores", gameScoreModelId), false);
    }

    @Override
    public List<GameScoreModel> getAllGamesScores() {
        DBConnectionManager.runQuery(SqlCommandsManager.selectAll("gameScores"));
        return (List<GameScoreModel>) DBConnectionManager.deserializeList(GameScoreModel.class);
    }

    @Override
    public RoomModel createRoomModel(RoomModel roomModel) {
        DBConnectionManager.runQuery(SqlCommandsManager.insertInto("rooms", roomModel));
        return (RoomModel) DBConnectionManager.deserialize(RoomModel.class);
    }

    @Override
    public RoomModel retrieveRoomModel(long roomModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.selectWhereId("rooms", roomModelId));
        return (RoomModel) DBConnectionManager.deserialize(RoomModel.class);
    }

    @Override
    public RoomModel updateRoomModel(RoomModel roomModel) {
        DBConnectionManager.runQuery(SqlCommandsManager.updateWhere("rooms", roomModel.getUpdateSet(), roomModel.getID()));
        return (RoomModel) DBConnectionManager.deserialize(RoomModel.class);
    }

    @Override
    public void deleteRoomModel(long roomModelId) {
        DBConnectionManager.runQuery(SqlCommandsManager.deleteWhereId("rooms", roomModelId), false);
    }

    @Override
    public List<RoomModel> getAllRoomModels() {
        DBConnectionManager.runQuery(SqlCommandsManager.selectAll("rooms"));
        return (List<RoomModel>) DBConnectionManager.deserializeList(RoomModel.class);
    }

    @Override
    public String getRandomSWFURL() {
        return null;
    }

    @Override
    public void removeSWFURL(String toRemove) {

    }
}
