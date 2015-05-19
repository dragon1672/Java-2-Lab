package edu.neumont.projectFiles.models;

import edu.neumont.projectFiles.models.interfaces.DAL;
import edu.neumont.projectFiles.models.services.DataBaseDAL;

/**
 * Created by bwaite on 5/19/2015.
 */
public class Singletons {
    public static DAL dbDAL = new DataBaseDAL();
}
