package edu.neumont.projectFiles.services;

import edu.neumont.projectFiles.interfaces.DBSerializable;

/**
 * Created by dericson on 5/26/2015.
 */
public class SqlCommandsManager {

    public static StringBuilder selectWhere(String table){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(table).append(" where ");
        return sb;
    }

    public static String selectWhereId(String table, long id){
        StringBuilder sb = selectWhere(table);
        sb.append("id = ").append(id).append(";");
        return sb.toString();
    }

    public static StringBuilder insert(String table){
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(table).append(" VALUES (");
        return sb;
    }

    public static String insertInto(String table, DBSerializable obj) {
        StringBuilder sb = insert(table);
        sb.append(obj.serialize()).append(") Returning *;");
        return sb.toString();
    }

    public static String updateWhere(String table, String setInfo, long id){
        StringBuilder sb = new StringBuilder();
        sb.append("update ").append(table).append(" set ").append(setInfo).append(" where id=").
                append(id).append(" returning *;");
        return sb.toString();
    }

    public static String getLast(String table){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(table).append(" order by id desc limit 1;");
        return sb.toString();
    }

    public static StringBuilder deleteWhere(String table){
        StringBuilder sb = new StringBuilder();
        sb.append("delete from ").append(table);
        return sb;
    }

    public static String deleteWhereId(String table, long id){
        StringBuilder sb = deleteWhere(table);
        sb.append(" where id = ").append(id).append(";");
        return sb.toString();
    }

    public static String selectAll(String table){
        return selectAll(table, "id");
    }

    public static String selectAll(String table, String orderedBy){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(table).append(" order by ").append(orderedBy).append(";");
        return sb.toString();
    }
}
