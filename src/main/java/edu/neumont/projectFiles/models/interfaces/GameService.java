package edu.neumont.projectFiles.models.interfaces;

import edu.neumont.projectFiles.models.GameModel;

/**
 * Created by bwaite on 5/19/2015.
 */
public interface GameService {

    //region Custom Exceptions ==================================================================================================

    /**
     * The user passed invalid data
     * RECOMMENDED: use throwable cause to have a more detailed exception
     */
    class UserExceptions extends GameServiceServiceExceptions {
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
    class ServiceExceptions extends GameServiceServiceExceptions {
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
    class NotFoundExceptions extends GameServiceServiceExceptions {
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
    class GameServiceServiceExceptions extends RuntimeException {
        public GameServiceServiceExceptions() {
            super();
        }
        public GameServiceServiceExceptions(String message) {
            super(message);
        }
        public GameServiceServiceExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public GameServiceServiceExceptions(Throwable cause) {
            super(cause);
        }
    }

    //endregion

    GameModel createGame(String name, String description);
    GameModel retrieveGame(long id);
    GameModel updateGame(GameModel user);
    void deleteGame(long id);
}
