package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.interfaces.DAL;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class DataBaseDAL implements DAL {

    @Override
    public UserModel createUser(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel retrieveUser(long userModelId) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return null;
    }

    @Override
    public void deleteUser(long userModelId) {

    }

    @Override
    public List<UserModel> GetAllUsers() {
        return null;
    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameID, long userId) {
        return null;
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public void deleteAchievement(long achievementModelId) {

    }

    @Override
    public void unlockAchievement(long userID, long achievementModelId) {

    }

    @Override
    public List<AchievementModel> GetAllAchievements() {
        return null;
    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        return null;
    }

    @Override
    public GameModel retrieveGameModel(long gameModelId) {
        return null;
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        return null;
    }

    @Override
    public void deleteGameModel(long gameModelId) {

    }

    @Override
    public List<GameModel> GetAllGames() {
        return null;
    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(long gameScoreModelId) {
        return null;
    }

    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public void deleteGameScore(long gameScoreModelId) {

    }

    @Override
    public List<GameScoreModel> GetAllGamesScores() {
        return null;
    }
}