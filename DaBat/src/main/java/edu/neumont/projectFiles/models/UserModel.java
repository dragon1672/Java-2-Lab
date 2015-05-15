package main.java.edu.neumont.projectFiles.models;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID user id. Primary key in the database.
 * @firstName the users first name.
 * @lastName the users last name.
 * @displayName the users name to be displayed on the site.
 * @email the users email.
 * @avatarURL The URl for the users avatar to display.
 */
public class UserModel {
    private long ID;
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;
    private String avatarURL;

    public UserModel(long ID){
        this.ID = ID;
    }

    public long getID(){
        return ID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAvatarURL(String url){
        this.avatarURL = avatarURL;
    }

    public String getSvatarURL(){
        return avatarURL;
    }
}
