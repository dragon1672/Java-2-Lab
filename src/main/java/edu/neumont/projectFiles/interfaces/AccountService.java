package edu.neumont.projectFiles.interfaces;

import edu.neumont.projectFiles.models.UserModel;
import utils.HtmlStringHelper;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public interface AccountService {

    //region Validation Helpers =================================================================================================
    default String validateInput(String input, String name) {
        if(input == null || input.isEmpty()) {
            throw new AccountService.UserExceptions(name + " cannot be null or empty",new IllegalArgumentException(name));
        }
        input = HtmlStringHelper.Sanitize(input);
        return input;
    }
    default void validateInput(Object input, String name) {
        if(input == null) {
            throw new AccountService.UserExceptions(name + " cannot be null",new IllegalArgumentException(name));
        }
    }
    //endregion
    //region Custom Exceptions ==================================================================================================

    /**
     * The user passed invalid data
     * RECOMMENDED: use throwable cause to have a more detailed exception
     */
    class UserExceptions extends AccountServiceExceptions {
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
    class ServiceExceptions extends AccountServiceExceptions {
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
    class NotFoundExceptions extends AccountServiceExceptions {
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
    class AccountServiceExceptions extends RuntimeException {
        public AccountServiceExceptions() {
            super();
        }
        public AccountServiceExceptions(String message) {
            super(message);
        }
        public AccountServiceExceptions(String message, Throwable cause) {
            super(message, cause);
        }
        public AccountServiceExceptions(Throwable cause) {
            super(cause);
        }
    }

    //endregion

    UserModel createUser(String firstName,String lastName,String displayName,String email,String avatarURL);
    UserModel retrieveUser(long id);
    UserModel updateUser(UserModel user);
    void deleteUser(long id);
    public List<UserModel> getAllUsers();
}
