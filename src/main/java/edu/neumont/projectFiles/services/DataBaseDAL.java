package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DBSerializable;
import edu.neumont.projectFiles.models.*;
import edu.neumont.projectFiles.interfaces.DAL;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class DataBaseDAL implements DAL{
    private File f = new File("../../../../../../../DatabaseReset.txt");


    @Override
    public UserModel createUserModel(UserModel userModel) {
        UserModel model = null;
        if(userModel != null) {
            String query = SqlCommandsManager.insertInto("users", userModel);
            model = callDBSingle(query, UserModel.class);
        }
        return model;
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        String query = SqlCommandsManager.selectWhereId("users", userModelId);
        return callDBSingle(query, UserModel.class);
    }

    @Override
    public UserModel retrieveUserModel(String username, String password) {
        StringBuilder query = SqlCommandsManager.selectWhere("users");
        query.append(" display_name = '").append(username).append("' and password = '").append(password).append("';");
        return callDBSingle(query.toString(), UserModel.class);
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        UserModel model = null;
        if(userModel != null) {
            String query = SqlCommandsManager.updateWhere("users", userModel.getUpdateSet(), userModel.getID());
            model = callDBSingle(query, UserModel.class);
        }
        return model;
    }

    @Override
    public void deleteUserModel(long userModelId) {
        String query = SqlCommandsManager.deleteWhereId("users", userModelId);
        callDBNoResult(query);
    }

    @Override
    public List<UserModel> getAllUsers() {
        String query = SqlCommandsManager.selectAll("users");
        return callDBList(query, UserModel.class, true);
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        GameModel model = null;
        if(gameModel != null) {
            String query = SqlCommandsManager.insertInto("games", gameModel);
            model = callDBSingle(query, GameModel.class);
        }
        return model;
    }

    @Override
    public GameModel retrieveGameModel(long gameModelId) {
        String query = SqlCommandsManager.selectWhereId("games", gameModelId);
        return callDBSingle(query, GameModel.class);
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        GameModel model = null ;
        if(gameModel != null) {
            String query = SqlCommandsManager.updateWhere("games", gameModel.getUpdateSet(), gameModel.getID());
            model = callDBSingle(query, GameModel.class);
        }
        return model;
    }

    @Override
    public void deleteGameModel(long gameModelId) {
        callDBNoResult(SqlCommandsManager.deleteWhereId("games", gameModelId));
    }

    @Override
    public List<GameModel> getAllGames() {
        return callDBList(SqlCommandsManager.selectAll("games"), GameModel.class, true);
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        AchievementModel model = null;
        if(achievementModel != null) {
            model = callDBSingle(SqlCommandsManager.insertInto("achievements", achievementModel), AchievementModel.class);
        }
        return model;
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameModelId, long achievementModelId) {
        return callDBSingle(SqlCommandsManager.selectWhereId("achievements", achievementModelId), AchievementModel.class);
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        AchievementModel model = null;
        if(achievementModel != null) {

            model = callDBSingle(SqlCommandsManager.updateWhere("achievements", achievementModel.getUpdateSet(), achievementModel.getID()), AchievementModel.class);
        }
        return model;
    }

    @Override
    public void deleteAchievement(long gameModelId, long achievementModelId) {
        callDBNoResult(SqlCommandsManager.deleteWhereId("achievements", achievementModelId));
    }

    @Override
    public void unlockAchievement(long userModelID, long achievementModelId) {
        StringBuilder sb = SqlCommandsManager.insert("userAchievements");
        sb.append(userModelID).append(", ").append(achievementModelId).append(")");
        callDBNoResult(sb.toString());
    }

    @Override
    public List<AchievementModel> getAllAchievements() {
        return callDBList(SqlCommandsManager.selectAll("achievements"), AchievementModel.class, true);
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        return callDBSingle(SqlCommandsManager.insertInto("gameScores", gameScoreModel), GameScoreModel.class);
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(long gameModelId, long gameScoreModelId) {
        return callDBSingle(SqlCommandsManager.selectWhereId("gameScores", gameScoreModelId), GameScoreModel.class);
    }

    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        GameScoreModel model = null;
        if(gameScoreModel != null) {
            model = callDBSingle(SqlCommandsManager.updateWhere("gameScores", gameScoreModel.getUpdateSet(), gameScoreModel.getID()), GameScoreModel.class);
        }
        return model;
    }

    @Override
    public void deleteGameScore(long gameModelId, long gameScoreModelId) {
        callDBNoResult(SqlCommandsManager.deleteWhereId("gameScores", gameScoreModelId));
    }

    @Override
    public List<GameScoreModel> getAllGamesScores() {
        return callDBList(SqlCommandsManager.selectAll("gameScores"), GameScoreModel.class, true);
    }

    @Override
    public RoomModel createRoomModel(RoomModel roomModel) {
        return callDBSingle(SqlCommandsManager.insertInto("rooms", roomModel), RoomModel.class);
    }

    @Override
    public RoomModel retrieveRoomModel(long roomModelId) {
        return callDBSingle(SqlCommandsManager.selectWhereId("rooms", roomModelId), RoomModel.class);
    }

    @Override
    public RoomModel updateRoomModel(RoomModel roomModel) {
        return callDBSingle(SqlCommandsManager.updateWhere("rooms", roomModel.getUpdateSet(), roomModel.getID()), RoomModel.class);
    }

    @Override
    public void deleteRoomModel(long roomModelId) {
        callDBNoResult(SqlCommandsManager.deleteWhereId("rooms", roomModelId));
    }

    @Override
    public List<RoomModel> getAllRoomModels() {
        return callDBList(SqlCommandsManager.selectAll("rooms"), RoomModel.class, true);
    }

    @Override
    public PlayerInRoomModel createPlayerInRoomModel(PlayerInRoomModel playerInRoomModel) {
        return callDBSingle(SqlCommandsManager.insertInto("playersInRooms", playerInRoomModel), PlayerInRoomModel.class);
    }

    @Override
    public PlayerInRoomModel retrievePlayerInRoomModel(long roomID, long playerID) {
        StringBuilder sb = SqlCommandsManager.selectWhere("playersInRooms");
        sb.append("player_id = ").append(playerID).append(" and room_id = ").append(roomID).append(";");
        return callDBSingle(sb.toString(), PlayerInRoomModel.class);
    }

    @Override
    public PlayerInRoomModel updatePlayerInRoomModel(PlayerInRoomModel roomModel) {
        StringBuilder sb = SqlCommandsManager.update("playersInRooms");
        sb.append(" set ").append(roomModel.getUpdateSet()).append(" where player_id =")
                .append(roomModel.getUserID()).append(" and room_id = ").append(roomModel.getRoomID())
                .append(" returning *;");
        return callDBSingle(sb.toString(), PlayerInRoomModel.class);
    }

    @Override
    public void deletePlayerInRoomModel(long roomId, long playerId) {
        StringBuilder sb = SqlCommandsManager.deleteWhere("playersInRooms");
        sb.append("player_id = ").append(playerId).append(" and ").append(roomId).append(";");
        callDBNoResult(sb.toString());
    }

    @Override
    public List<PlayerInRoomModel> getAllPlayerInRoomModels(long roomId) {
        StringBuilder sb = SqlCommandsManager.selectWhere("playersInRooms").append(" room_id =").append(roomId).append(";");
        return callDBList(sb.toString(), PlayerInRoomModel.class, true);
    }

    private static class SwfSerializable implements DBSerializable{
        String url;
        @Override
        public DBSerializable deserialize(ResultSet set) throws SQLException {
            this.url = set.getString("url");
            return this;
        }
        @Override public String serialize() {return null;}
        @Override public String getUpdateSet() {return null;}
    }

    @Override
    public String getRandomSWFURL() {
        String query = "select * from swfs order by random() limit 1;";
        SwfSerializable swf =  callDBSingle(query, SwfSerializable.class);
        return swf.url;
    }

    @Override
    public void removeSWFURL(String toRemove) {
        String query = "delete from swfs where url = "+toRemove+";";
        String otherQuery = "insert into deletedSwfs VALUES("+toRemove+");";
        callDBNoResult(query);
        callDBNoResult(otherQuery);
    }

    private synchronized <T extends DBSerializable> List<T>  callDBList(String query, Class<T> item, boolean hasResult){
        DBConnectionManager.runQuery(query, hasResult);
        List<T> items = null;
        if(hasResult) {
            items =  (List<T>) DBConnectionManager.deserializeList(item);
        }
        return items;
    }

    private <T extends DBSerializable> T callDBNoResult(String query){
        return callDBSingle(query, null, false);
    }

    private <T extends DBSerializable> T callDBSingle(String query, Class<T> item){
        return callDBSingle(query, item, true);
    }

    private <T extends DBSerializable> T callDBSingle(String query, Class<T> item, boolean hasResult){
        List<T> items = callDBList(query, item, hasResult);
        T result = (items.size()>0)?items.get(0):null;
        return result;
    }

}
