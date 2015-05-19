package edu.neumont.projectFiles.models.services;

import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.models.interfaces.AccountService;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class LocalAccountService implements AccountService{
    @Override
    public UserModel createUser(String firstName, String lastName, String displayName, String email, String avatarURL) {
        //use -1 for id, Database will assign ID later.
        UserModel userM = null;
                //new UserModel(-1,firstName,lastName,displayName,email,avatarURL);
        return null;
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
