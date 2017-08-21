package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shakil
 */
public class StockIdFinder {

    String id;
    String table;
    String fromName;
    String name;
    String find_id;
    int retid;

    public int findId(String id, String table, String fromName, String name) {

        this.id = id;
        this.table = table;
        this.fromName = fromName;
        this.name = name;

        System.out.println("stock finder  id = > " + this.id);

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String id_query = "SELECT " + this.id + " from " + this.table + " WHERE " + this.fromName + "='" + this.name + "'";

            ResultSet rs = dbConnection.statement.executeQuery(id_query);
            try {

                while (rs.next()) {
                    find_id = rs.getString(this.id);
                    retid = Integer.parseInt(find_id);
                }
            } catch (SQLException e) {

                System.out.println(" 1st ---- >> " + e);
            }

        } catch (Exception e) {
            System.out.println(" up => " + e);
        }

        return retid;
    }

}
