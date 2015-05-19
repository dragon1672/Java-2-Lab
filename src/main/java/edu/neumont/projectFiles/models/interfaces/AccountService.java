package edu.neumont.projectFiles.models.interfaces;

import edu.neumont.projectFiles.models.UserModel;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public interface AccountService {
    UserModel createUser(String username, String imageSource);
    UserModel retrieveUser(String username);
    UserModel updateUser(UserModel user);
    void deleteUser(String username);
    public List<UserModel> getAllUsers();
}
