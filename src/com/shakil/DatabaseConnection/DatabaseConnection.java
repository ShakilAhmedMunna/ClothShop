package com.shakil.DatabaseConnection;

import com.shakil.DatabaseVariableConstants.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shakil
 */
public class DatabaseConnection {

    public Connection connection;
    public Statement statement;
    public ResultSet resultset;

    public DatabaseConnection() {
        try {
            Class.forName(Constants.ShopManagement_DRIVER);

            connection = DriverManager.getConnection(Constants.ShopManagement_DB, Constants.ShopManagement_DB_USERNAME, Constants.ShopManagement_DB_PASSWORD);
            statement = connection.createStatement();

        } catch (Exception e) {
            System.err.print(e);
        }

    }

}
