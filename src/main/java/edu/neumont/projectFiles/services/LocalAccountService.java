package edu.neumont.projectFiles.services;


import edu.neumont.projectFiles.interfaces.AccountService;
import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.models.UserModel;

import java.util.List;

/**
 * Created by bwaite on 5/19/2015.
 */
public class LocalAccountService implements AccountService {

    private DAL myDal;

    public LocalAccountService(DAL myDal) {
        this.myDal = myDal;
    }

    @Override
    public UserModel createUser(String firstName, String lastName, String displayName, String email, String avatarURL) {
        firstName = validateInput(firstName,"firstName");
        lastName = validateInput(lastName,"lastName");
        displayName = validateInput(displayName,"displayName");
        email = validateInput(email,"email");
        avatarURL = validateInput(avatarURL,"avatarURL");
        //use -1 for id, Database will assign ID later.
        UserModel userM = new UserModel(-1,firstName,lastName,displayName,email,avatarURL);
        userM = myDal.createUserModel(userM);
        return  userM;
    }

    @Override
    public UserModel retrieveUser(long id) {
        return myDal.retrieveUserModel(id);
    }

    //TODO:password not used yet
    @Override
    public UserModel retrieveUserModel(String username, String password) {
        return myDal.retrieveUserModel(username,password);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel uInDB = myDal.retrieveUserModel(user.getID());
        UserModel uNew = null;
        if(uInDB != null)
        {
            uNew = new UserModel(user.getID(),
                    validateInput(user.getFirstName(), "firstName"),
                    validateInput(user.getLastName(),"lasName"),
                    validateInput(user.getDisplayName(),"displayName"),
                    validateInput(user.getEmail(),"email"),
                    validateInput(user.getAvatarURL(),"avatarURL"));
            uNew = myDal.updateUserModel(uNew);
        }
        return uNew;
    }

    @Override
    public void deleteUser(long id) {
        myDal.deleteUserModel(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return myDal.GetAllUsers();
    }
}
