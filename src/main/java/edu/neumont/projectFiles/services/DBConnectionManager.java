package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DBSerializable;

import javax.xml.transform.Result;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by dericson on 5/21/2015.
 */
public class DBConnectionManager {
    private static int useCount;
    private static Connection connection = null;
    private static ResultSet currSet;

    private static Connection getCurrConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            if(connection == null || connection.isClosed()) {
                String myUrl = "postgres://ooukjqcdwvrdno:iEff2xGGpDhH3va3wlwkyX1CNh@ec2-174-129-26-115.compute-1.amazonaws.com:5432/d1a6kag310met4";
                String herokuUrl = (System.getenv("DATABASE_URL") == null) ? "postgres://cuxduoqzookudi:WszHgQ-cwcFwF2ZOljG8N8XKcP@ec2-54-243-187-196.compute-1." +
                        "amazonaws.com:5432/d8df7jnj2bddgg" : System.getenv("DATABASE_URL");
                URI dbUri = new URI(myUrl);
                String[] values = dbUri.getUserInfo().split(":");

                String username = values[0];
                String password = values[1];
                int port = dbUri.getPort();

                String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath() + "?user=" + username + "&password=" + password + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
                connection = DriverManager.getConnection(dbUrl, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        useCount++;
        return connection;
    }

    public static ResultSet runQuery(String query){
        ResultSet set = null;
        Statement stm = null;
        try {
            if(connection == null || connection.isClosed()){
                getCurrConnection();
            }
            stm = connection.createStatement();
            currSet = set = stm.executeQuery(query);
            useCount--;
            if(useCount == 0){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return set;
        }
    }

    public static DBSerializable deserialize(Class<? extends DBSerializable> instance){
        try {
            DBSerializable obj = instance.newInstance();
            return obj.deserialize(currSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<? extends DBSerializable> deserializeList(DBSerializable obj){
        List<DBSerializable> items = new ArrayList<>();
        try {
            while(currSet.next()){
                items.add(obj.deserialize(currSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return items;
    }
}
