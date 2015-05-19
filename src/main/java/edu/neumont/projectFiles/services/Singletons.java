package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DAL;
import edu.neumont.projectFiles.services.DataBaseDAL;

/**
 * Created by bwaite on 5/19/2015.
 */
public class Singletons {
    public static DAL theDAL = new DataBaseDAL();
}
