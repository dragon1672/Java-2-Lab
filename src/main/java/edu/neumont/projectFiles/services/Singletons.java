package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.AccountService;
import edu.neumont.projectFiles.interfaces.DAL;
import utils.Logger;

/**
 * Created by bwaite on 5/19/2015.
 */
public class Singletons {
    public static DAL theDAL = /*new LocalInMemoryDal();*/new DataBaseDAL();
    public static final Logger logger = new Logger.LoggerBuilder().add(System.out).setLevel(Logger.PrintLevel.TRACE).build();
    public static AccountService accountService = new LocalAccountService();

    static {
        accountService.createUser("Brittany", "Waite", "bnwbnw3", "NO@yourbusiness.goAway", "http://i.imgur.com/WS8ae2M.jpg?1");
        accountService.createUser("Anthony", "Corbin", "dragon1672", "no@email.4u", "http://i.imgur.com/76y9kf6.gif");
    }
}

