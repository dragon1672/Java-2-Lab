package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DAL;

/**
 * Created by bwaite on 5/19/2015.
 */
public class Singletons {
    public static DAL theDAL = new LocalInMemoryDal();//new DataBaseDAL();
}
