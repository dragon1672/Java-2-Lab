package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DAL;
import utils.Logger;

/**
 * Created by bwaite on 5/19/2015.
 */
public class Singletons {
    public static DAL theDAL = new LocalInMemoryDal();//new DataBaseDAL();


    public static final Logger logger = new Logger.LoggerBuilder().add(System.out).setLevel(Logger.PrintLevel.TRACE).build();
}
