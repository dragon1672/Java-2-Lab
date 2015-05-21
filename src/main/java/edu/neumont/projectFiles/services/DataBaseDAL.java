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
    public UserModel createUserModel(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel retrieveUserModel(long userModelId) {
        return null;
    }

    //TODO:password not used yet
    @Override
    public UserModel retrieveUserModel(String username, String password) {
        return null;
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        return null;
    }

    @Override
    public void deleteUserModel(long userModelId) {

    }

    @Override
    public List<UserModel> GetAllUsers() {
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
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public AchievementModel retrieveAchievementModel(long gameModelId, long achievementModelId) {
        return null;
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public void deleteAchievement(long gameModelId, long achievementModelId) {

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
