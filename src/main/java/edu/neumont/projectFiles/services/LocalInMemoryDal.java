package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.*;
import utils.Tuple;

import java.util.*;

/**
 * Created by bwaite on 5/20/2015.
 */
public class LocalInMemoryDal implements DAL{
    Map<Long,UserModel> users = new HashMap<>();
    Map<Long,GameModel> games = new HashMap<>();
    Map<Tuple<Long,Long>, AchievementModel> achievements = new HashMap<>();
    Map<UserModel, AchievementModel> unlockedAchievements = new HashMap<>();
    Map<Tuple<Long,Long>, GameScoreModel> gameScores = new HashMap<>();
    Map<Long, RoomModel> rooms = new HashMap<>();
    private static long gameIDCounter = 0;
    private static long userIDCounter = 0;
    private static long achievementIDCounter = 0;
    private static long gameScoreIDCounter = 0;
    private static long gameRoomIDCounter = 0;


    @Override
    public UserModel createUserModel(UserModel userModel) {
        long userID = userIDCounter++;
        userModel = new UserModel(userID,userModel.getFirstName(), userModel.getLastName(), userModel.getDisplayName(),userModel.getEmail(), userModel.getAvatarURL());
        users.put(userID,userModel);
        return users.get(userID);
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        return users.get(userModelId);
    }

    //TODO:password not used yet
    @Override
    public UserModel retrieveUserModel(String username, String password) {
        UserModel userModel = null;
        for(Map.Entry<Long, UserModel> u : users.entrySet()) {
            if(u.getValue().getDisplayName().equals(username))
            {
                userModel = u.getValue();
                break;
            }
        }
        return userModel;
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        users.remove(userModel.getID());
        users.put(userModel.getID(), userModel);
        return users.get(userModel.getID());
    }

    @Override
    public void deleteUserModel(long userModelId) {
        users.remove(userModelId);
    }

    @Override
    public List<UserModel> GetAllUsers() {
        List<UserModel> allUsers = new ArrayList<>();
        for(Map.Entry<Long,UserModel> userEntry : users.entrySet())
        {
            allUsers.add(userEntry.getValue());
        }
        return allUsers;
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        long gameID = gameIDCounter++;
        gameModel = new GameModel(gameID,gameModel.getName(),gameModel.getDescription());
        games.put(gameID,gameModel);
        return games.get(gameID);
    }

    @Override
    public GameModel retrieveGameModel(long gameModelId) {
        return games.get(gameModelId);
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        games.remove(gameModel.getID());
        games.put(gameModel.getID(), gameModel);
        return games.get(gameModel.getID());
    }

    @Override
    public void deleteGameModel(long gameModelId) {
        games.remove(gameModelId);
    }

    @Override
    public List<GameModel> GetAllGames() {
        List<GameModel> allGames = new ArrayList<>();
        for(Map.Entry<Long,GameModel> gameEntry : games.entrySet())
        {
            allGames.add(gameEntry.getValue());
        }
        return allGames;
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        Long achievementID = achievementIDCounter++;
        achievementModel = new AchievementModel(achievementID,achievementModel.getGameID());
        achievements.put(new Tuple<>(achievementModel.getGameID(), achievementID),achievementModel);
        return achievements.get(new Tuple<>(achievementModel.getGameID(),achievementID));
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameModelID, long achievementModelId) {
        return achievements.get(new Tuple<>(gameModelID,achievementModelId));
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        achievements.remove(new Tuple<>(achievementModel.getGameID(),achievementModel.getID()));
        achievements.put(new Tuple<>(achievementModel.getGameID(), achievementModel.getID()), achievementModel);
        return achievements.get(new Tuple<>(achievementModel.getGameID(),achievementModel.getID()));
    }

    @Override
    public void deleteAchievement(long gameModelID,long achievementModelId) {
        achievements.remove(new Tuple<>(gameModelID, achievementModelId));
    }

    @Override
    public void unlockAchievement(long userID, long achievementModelId) {
        unlockedAchievements.put(users.get(userID), achievements.get(achievementModelId));
    }

    @Override
    public List<AchievementModel> GetAllAchievements() {
        List<AchievementModel> allAchievements = new ArrayList<>();
        for(Map.Entry<Tuple<Long,Long>,AchievementModel> achievementEntry : achievements.entrySet())
        {
            allAchievements.add(achievementEntry.getValue());
        }
        return allAchievements;
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        long gameScoreID = gameScoreIDCounter++;
        gameScoreModel = new GameScoreModel(gameScoreID,gameScoreModel.getUserID(),gameScoreModel.getGameID(),gameScoreModel.getScore(),gameScoreModel.getDate());
        gameScores.put(new Tuple<>(gameScoreModel.getGameID(),gameScoreID),gameScoreModel);
        return gameScores.get(new Tuple<>(gameScoreModel.getGameID(),gameScoreID));
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(long gameModelId, long gameScoreModelId) {
        return gameScores.get(new Tuple<>(gameModelId, gameScoreModelId));
    }


    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        gameScores.remove(new Tuple<>(gameScoreModel.getGameID(),gameScoreModel.getID()));
        gameScores.put(new Tuple<>(gameScoreModel.getGameID(), gameScoreModel.getID()), gameScoreModel);
        return gameScores.get(new Tuple<>(gameScoreModel.getGameID(),gameScoreModel.getID()));
    }

    @Override
    public void deleteGameScore(long gameModelId, long gameScoreModelId) {
        gameScores.remove(new Tuple<>(gameModelId, gameScoreModelId));
    }


    @Override
    public List<GameScoreModel> GetAllGamesScores() {
        List<GameScoreModel> allGameScores = new ArrayList<>();
        for(Map.Entry<Tuple<Long,Long>,GameScoreModel> gameEntry : gameScores.entrySet())
        {
            allGameScores.add(gameEntry.getValue());
        }
        return allGameScores;
    }

    @Override
    public RoomModel createRoomModel(RoomModel roomModel)
    {
        RoomModel newRoom = new RoomModel(gameRoomIDCounter++,roomModel.getGameID(),roomModel.getRoomName(),roomModel.getTimePosted(), roomModel.getMaxPlayers(), roomModel.getPassword());
        rooms.put(newRoom.getID(), newRoom);
        return rooms.get(newRoom.getID());
    }

    @Override
    public RoomModel retrieveRoomModel(long roomModelId)
    {
        return rooms.get(roomModelId);
    }

    @Override
    public RoomModel updateRoomModel(RoomModel roomModel)
    {
        rooms.remove(roomModel.getID());
        rooms.put(roomModel.getID(), roomModel);
        return rooms.get(roomModel.getID());
    }

    @Override
    public void deleteRoomModel(long roomModelId) {
        rooms.remove(roomModelId);
    }

    @Override
    public List<RoomModel> GetAllRoomModels() {
        List<RoomModel> allRoomModels = new ArrayList<>();
        for(Map.Entry<Long, RoomModel> roomModelEntry: rooms.entrySet()){
            allRoomModels.add(roomModelEntry.getValue());
        }
        return  allRoomModels;
    }
}
