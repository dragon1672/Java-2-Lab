package edu.neumont.projectFiles.models.services;

import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.models.interfaces.DAL;

/**
 * Created by bwaite on 5/19/2015.
 */
public class DataBaseDAL implements DAL {
    @Override
    public UserModel createUser(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel retrieveUser(int userModelId) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return null;
    }

    @Override
    public void deleteUser(int userModelId) {

    }

    @Override
    public AchievementModel createAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public AchievementModel retrieveAchievementModel(int gameID, int userId) {
        return null;
    }

    @Override
    public AchievementModel updateAchievementModel(AchievementModel achievementModel) {
        return null;
    }

    @Override
    public void deleteAchievement(int achievementModelId) {

    }

    @Override
    public void unlockAchievement(int userID, int achievementModelId) {

    }

    @Override
    public GameModel createGameModel(GameModel gameModel) {
        return null;
    }

    @Override
    public GameModel retrieveGameModel(int gameModelId) {
        return null;
    }

    @Override
    public GameModel updateGameModel(GameModel gameModel) {
        return null;
    }

    @Override
    public void deleteGameModel(int gameModelId) {

    }

    @Override
    public GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public GameScoreModel retrieveGameScoreModel(int gameScoreModelId) {
        return null;
    }

    @Override
    public GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel) {
        return null;
    }

    @Override
    public void deleteGameScore(int gameScoreModelId) {

    }
}
