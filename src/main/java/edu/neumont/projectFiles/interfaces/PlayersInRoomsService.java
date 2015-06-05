package edu.neumont.projectFiles.interfaces;

import edu.neumont.projectFiles.models.PlayerInRoomModel;
import utils.HtmlStringHelper;

import java.util.List;

/**
 * Created by tlousignont on 6/3/2015.
 */
public interface PlayersInRoomsService {
    //region Validation Helpers =================================================================================================
    default String validateInput(String input, String name) {
        if(input == null || input.isEmpty()) {
            throw new RoomService.UserExceptions(name + " cannot be null or empty",new IllegalArgumentException(name));
        }
        input = HtmlStringHelper.Sanitize(input);
        return input;
    }
    default void validateInput(Object input, String name) {
        if(input == null) {
            throw new GameService.UserExceptions(name + " cannot be null",new IllegalArgumentException(name));
        }
    }
    //endregion
    //region Custom Exceptions ==================================================================================================

    /**
     * The user passed invalid data
     * RECOMMENDED: use throwable cause to have a more detailed exception
     */
    class UserExceptions extends RoomServiceServiceExceptions {
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
    class ServiceExceptions extends RoomServiceServiceExceptions {
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
    class NotFoundExceptions extends RoomServiceServiceExceptions {
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
    class RoomServiceServiceExceptions extends RuntimeException {
        public RoomServiceServiceExceptions() {
            super();
        }
        public RoomServiceServiceExceptions(String message) {
            super(message);
        }
        public RoomServiceServiceExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public RoomServiceServiceExceptions(Throwable cause) {
            super(cause);
        }
    }

    //endregion

    PlayerInRoomModel createPlayerInRoomModel(long roomId, long playerId);
    PlayerInRoomModel retrievePlayerInRoomModel(long roomId, long playerId);
    PlayerInRoomModel updatePlayerInRoomModel(PlayerInRoomModel room);
    void deletePlayerInRoomModel(long roomId, long playerId);
    List<PlayerInRoomModel> getAllPlayerInRoomModel(long roomId);
}
