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
        UserModel userM = new UserModel(-1,firstName,lastName,displayName,email,avatarURL);
        Singletons.theDAL.createUser(userM);
        return userM;
    }

    @Override
    public UserModel retrieveUser(long id) {
        return Singletons.theDAL.retrieveUser(id);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel uInDB = Singletons.theDAL.retrieveUser(user.getID());
        UserModel uNew = null;
        if(uInDB != null)
        {
            uNew = new UserModel(user.getID(),
                    validateInput(user.getFirstName(), "firstName"),
                    validateInput(user.getLastName(),"lasName"),
                    validateInput(user.getDisplayName(),"displayName"),
                    validateInput(user.getEmail(),"email"),
                    validateInput(user.getAvatarURL(),"avatarURL"));
            Singletons.theDAL.updateUser(uNew);
        }
        return uNew;
    }

    @Override
    public void deleteUser(long id) {
        Singletons.theDAL.deleteUser(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return Singletons.theDAL.GetAllUsers();
    }
}
