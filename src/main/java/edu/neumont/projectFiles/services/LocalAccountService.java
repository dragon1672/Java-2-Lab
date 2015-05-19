package edu.neumont.projectFiles.services;


import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.interfaces.AccountService;
import utils.HtmlStringHelper;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class LocalAccountService implements AccountService {

    //region validation helpers
    String validateInput(String input, String name) {
        if(input == null || input.isEmpty()) {
            throw new AccountService.UserExceptions(name + " cannot be null or empty",new IllegalArgumentException(name));
        }
        input = HtmlStringHelper.Sanatize(input);
        return input;
    }
    void validateInput(Object input, String name) {
        if(input == null) {
            throw new AccountService.UserExceptions(name + " cannot be null",new IllegalArgumentException(name));
        }
    }
    //endregion

    @Override
    public UserModel createUser(String firstName, String lastName, String displayName, String email, String avatarURL) {
        firstName = validateInput(firstName,"firstName");
        lastName = validateInput(lastName,"lastName");
        displayName = validateInput(displayName,"displayName");
        email = validateInput(email,"email");
        avatarURL = validateInput(avatarURL,"avatarURL");
        //use -1 for id, Database will assign ID later.
        UserModel userM = new UserModel(-1,firstName,lastName,displayName,email,avatarURL);
        Singletons.theDAL.createUser(userM);
        return userM;
    }

    @Override
    public UserModel retrieveUser(long id) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public List<UserModel> getAllUsers() {
        return null;
    }
}
