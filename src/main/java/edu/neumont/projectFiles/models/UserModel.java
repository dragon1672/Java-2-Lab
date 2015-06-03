package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tlousignont on 5/15/2015.
 * @ID user id. Primary key in the database.
 * @firstName the users first name.
 * @lastName the users last name.
 * @displayName the users name to be displayed on the site.
 * @email the users email.
 * @avatarURL The URl for the users avatar to display.
 */
public class UserModel implements DBSerializable {
    private long ID;
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;
    private String avatarURL;

    public UserModel(){
    }

    public UserModel(String firstName, String lastName, String displayName, String email, String avatarURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.avatarURL = avatarURL;
    }

    private UserModel(long id, String firstName, String lastName, String displayName, String email, String avatarURL){
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.avatarURL = avatarURL;
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

    public String getAvatarURL(){
        return avatarURL;
    }

    @Override
    public DBSerializable deserialize(ResultSet set) throws SQLException {
        long id = set.getLong("id");
        String first_Name = set.getString("first_name");
        String last_Name = set.getString("last_name");
        String display_Name = set.getString("display_name");
        String email = set.getString("email");
        String avatarURL = set.getString("avatar_url");
        return new UserModel(id, first_Name, last_Name, display_Name, email, avatarURL);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        firstName = firstName.replaceAll("'", "''");
        lastName = lastName.replaceAll("'", "''");
        displayName = displayName.replaceAll("'", "''");
        email = email.replaceAll("'", "''");
        avatarURL = avatarURL.replaceAll("'", "''");
        sb.append("default, '").append(firstName).append("', '").append(lastName).
                append("', '").append(displayName).append("', '").append(email).
                append("', '").append(avatarURL).append("', 'password'");
        return sb.toString();
    }

    @Override
    public String getUpdateSet(){
        StringBuilder sb = new StringBuilder();
        firstName = firstName.replaceAll("'", "''");
        lastName = lastName.replaceAll("'", "''");
        displayName = displayName.replaceAll("'", "''");
        email = email.replaceAll("'", "''");
        avatarURL = avatarURL.replaceAll("'", "''");
        sb.append("(first_name, last_name, display_name, email, avatar_url) = (").append("'").append(firstName).append("', '").append(lastName)
                .append("', '").append(displayName).append("', '").append(email).append("', '").append(avatarURL).append("')");
        return sb.toString();
    }
}
