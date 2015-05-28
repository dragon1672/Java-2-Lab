package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;
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
    private static long gameIDCounter = 0;
    private static long userIDCounter = 0;
    private static long achievementIDCounter = 0;
    private static long gameScoreIDCounter = 0;


    @Override
    public UserModel createUserModel(UserModel userModel) {
        users.put(userIDCounter++,userModel);
        return users.get(userModel.getID());
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        return users.get(userModelId);
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
    public List<UserModel> getAllUsers() {
        List<UserModel> allUsers = new ArrayList<>();
        for(Map.Entry<Long,UserModel> userEntry : users.entrySet())
        {
            allUsers.add(userEntry.getValue());
        }
        return allUsers;
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        games.put(gameIDCounter++,gameModel);
        return games.get(gameModel.getID());
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
    public List<GameModel> getAllGames() {
        List<GameModel> allGames = new ArrayList<>();
        for(Map.Entry<Long,GameModel> gameEntry : games.entrySet())
        {
            allGames.add(gameEntry.getValue());
        }
        return allGames;
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        achievements.put(new Tuple<>(achievementModel.getGameID(), achievementIDCounter++),achievementModel);
        return achievements.get(new Tuple<>(achievementModel.getGameID(),achievementModel.getID()));
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
    public List<AchievementModel> getAllAchievements() {
        List<AchievementModel> allAchievements = new ArrayList<>();
        for(Map.Entry<Tuple<Long,Long>,AchievementModel> achievementEntry : achievements.entrySet())
        {
            allAchievements.add(achievementEntry.getValue());
        }
        return allAchievements;
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        gameScores.put(new Tuple<>(gameScoreModel.getGameID(),gameScoreIDCounter++),gameScoreModel);
        return gameScores.get(new Tuple<>(gameScoreModel.getGameID(),gameScoreModel.getID()));
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
    public List<GameScoreModel> getAllGamesScores() {
        List<GameScoreModel> allGameScores = new ArrayList<>();
        for(Map.Entry<Tuple<Long,Long>,GameScoreModel> gameEntry : gameScores.entrySet())
        {
            allGameScores.add(gameEntry.getValue());
        }
        return allGameScores;
    }
}
