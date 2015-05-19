package edu.neumont.projectFiles.interfaces;

import edu.neumont.projectFiles.models.AchievementModel;
import edu.neumont.projectFiles.models.GameModel;
import edu.neumont.projectFiles.models.GameScoreModel;
import edu.neumont.projectFiles.models.UserModel;

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

    //region User DAL
    UserModel createUser(UserModel userModel);
    UserModel retrieveUser(int userModelId);
    UserModel updateUser(UserModel userModel);
    void deleteUser(int userModelId);
    //endregion
    //region Achievement DAL
    AchievementModel createAchievementModel(AchievementModel achievementModel);
    AchievementModel retrieveAchievementModel(int gameID, int userId);
    AchievementModel updateAchievementModel(AchievementModel achievementModel);
    void deleteAchievement(int achievementModelId);
    void unlockAchievement(int userID, int achievementModelId);
    //endregion
    //region Game DAL
    GameModel createGameModel(GameModel gameModel);
    GameModel retrieveGameModel(int gameModelId);
    GameModel updateGameModel(GameModel gameModel);
    void deleteGameModel(int gameModelId);
    //endregion
    //region GameScore DAL
    GameScoreModel createGameScoreModel(GameScoreModel gameScoreModel);
    GameScoreModel retrieveGameScoreModel(int gameScoreModelId);
    GameScoreModel updateGameScoreModel(GameScoreModel gameScoreModel);
    void deleteGameScore(int gameScoreModelId);
    //endregion
}
