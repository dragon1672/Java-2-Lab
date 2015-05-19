package edu.neumont.projectFiles.models.interfaces;

import edu.neumont.projectFiles.models.UserModel;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public interface AccountService {
    UserModel createUser(String firstName,String lastName,String displayName,String email,String avatarURL);
    UserModel retrieveUser(long id);
    UserModel updateUser(UserModel user);
    void deleteUser(long id);
    public List<UserModel> getAllUsers();
}
