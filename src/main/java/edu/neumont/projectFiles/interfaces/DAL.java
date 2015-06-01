package edu.neumont.projectFiles.interfaces;

import edu.neumont.projectFiles.models.*;

import java.util.List;

/**
 * Created by bwaite on 5/15/2015.
 */
public interface DAL {

    //region Custom Exceptions ==================================================================================================

    /**
     * The user passed invalid data
     * RECOMMENDED: use throwable cause to have a more detailed exception
     */
    class UserExceptions extends DALExceptions {
        public UserExceptions() {
            super();
        }
        public UserExceptions(String message) {
            super(message);
        }
        public UserExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public UserExceptions(Throwable cause) {
            super(cause);
        }
    }

    /**
     * Something went wrong with the server
     */
    class ServiceExceptions extends DALExceptions {
        public ServiceExceptions() {
            super();
        }
        public ServiceExceptions(String message) {
            super(message);
        }
        public ServiceExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public ServiceExceptions(Throwable cause) {
            super(cause);
        }
    }

    /**
     * The identifier the user passed in was not contained in this service
     */
    class NotFoundExceptions extends DALExceptions {
        public NotFoundExceptions() {
            super();
        }
        public NotFoundExceptions(String message) {
            super(message);
        }
        public NotFoundExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public NotFoundExceptions(Throwable cause) {
            super(cause);
        }
    }

    /**
     * All Exceptions throw by this class should somehow be from this type
     */
    class DALExceptions extends RuntimeException {
        public DALExceptions() {
            super();
        }
        public DALExceptions(String message) {
            super(message);
        }
        public DALExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public DALExceptions(Throwable cause) {
            super(cause);
        }
    }

    //endregion

    //region User DAL ===========================================================================================================
    UserModel createUserModel(UserModel userModel);
    UserModel retrieveUserModel(long userModelId);
    //TODO:password not used yet
    UserModel retrieveUserModel(String username, String password);
    UserModel updateUserModel(UserModel userModel);
    void deleteUserModel(long userModelId);
    List<UserModel> GetAllUsers();
    //endregion

    //region Game DAL ===========================================================================================================
    GameModel createGameModel(GameModel gameModel);
    GameModel retrieveGameModel(long gameModelId);
    GameModel updateGameModel(GameModel gameModel);
    void deleteGameModel(long gameModelId);
    List<GameModel> GetAllGames();
    //endregion

    //region Achievement DAL ====================================================================================================
    AchievementModel createAchievementModel(AchievementModel achievementModel);
    AchievementModel retrieveAchievementModel(long gameModelId, long achievementModelId);
    AchievementModel updateAchievementModel(AchievementModel achievementModel);
    void deleteAchievement(long gameModelId,long achievementModelId);
    void unlockAchievement(long userModelID, long achievementModelId);
    List<AchievementModel> GetAllAchievements();
    //endregion

    //region GameScore DAL ======================================================================================================
    GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel);
    GameScoreModel retrieveGameScoreModel(long gameModelId, long gameScoreModelId);
    GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel);
    void deleteGameScore(long gameModelId,long gameScoreModelId);
    List<GameScoreModel> GetAllGamesScores();
    //endregion

    //region GameRoom DAL =======================================================================================================
    RoomModel createRoomModel(RoomModel roomModel);
    RoomModel retrieveRoomModel(long roomModelId);
    RoomModel updateRoomModel(RoomModel roomModel);
    void deleteRoomModel(long roomModelId);
    List<RoomModel> GetAllRoomModels();
    //endregion

    /**
     * returns a random valid SWF url
     * @return a random valid SWF url
     */
    String getRandomSWFURL();

    /**
     * Shouldn't throw any exceptions
     * @param toRemove URL to remove
     */
    void removeSWFURL(String toRemove);
}
