package edu.neumont.projectFiles.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dericson on 5/21/2015.
 */
public interface DBSerializable {
    DBSerializable deserialize(ResultSet set) throws SQLException;
    String serialize();
    String getUpdateSet();
}
