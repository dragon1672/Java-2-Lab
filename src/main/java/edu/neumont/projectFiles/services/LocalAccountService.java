package edu.neumont.projectFiles.services;


import edu.neumont.projectFiles.interfaces.AccountService;
import edu.neumont.projectFiles.models.UserModel;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class LocalAccountService implements AccountService {

    @Override
    public UserModel createUser(String firstName, String lastName, String displayName, String email, String avatarURL) {
        firstName = validateInput(firstName,"firstName");
        lastName = validateInput(lastName,"lastName");
        displayName = validateInput(displayName,"displayName");
        email = validateInput(email,"email");
        avatarURL = validateInput(avatarURL,"avatarURL");
        //use -1 for id, Database will assign ID later.
        UserModel userM = new UserModel(firstName,lastName,displayName,email,avatarURL);
        return Singletons.theDAL.createUserModel(userM);
    }

    @Override
    public UserModel retrieveUser(long id) {
        return Singletons.theDAL.retrieveUserModel(id);
    }

    @Override
    public UserModel retrieveUserModel(String username, String password) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel uInDB = Singletons.theDAL.retrieveUserModel(user.getID());
        UserModel uNew = null;
        if(uInDB != null)
        {
            uNew = new UserModel(
                    validateInput(user.getFirstName(), "firstName"),
                    validateInput(user.getLastName(),"lasName"),
                    validateInput(user.getDisplayName(),"displayName"),
                    validateInput(user.getEmail(),"email"),
                    validateInput(user.getAvatarURL(),"avatarURL"));
            Singletons.theDAL.updateUserModel(uNew);
        }
        return uNew;
    }

    @Override
    public void deleteUser(long id) {
        Singletons.theDAL.deleteUserModel(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return Singletons.theDAL.getAllUsers();
    }
}
