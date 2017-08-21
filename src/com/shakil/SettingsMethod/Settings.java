package com.shakil.SettingsMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author Shakil
 */
public class Settings {
    
    String table;
    String value;
    String a;
    String b;
    
    
    
    public void Insert(String table , String value,String b){
        
        System.out.println(" " + table+" "+ value+" "+" "+ b);
        
        this.table = table;
        this.value = value;
        this.a = a;
        this.b = b;
        
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();

          // String insert_query = "INSERT INTO "+this.table+"('"+this.b+"') VALUES ('"+this.value+"')";
           // String insert_query = "INSERT INTO product (product_name) VALUES ('kattan')";
            String insert_query = "INSERT INTO "+this.table+" ("+this.b+") VALUES ('"+this.value+"')";
            
            System.out.println("hello");
           dbConnection.statement.executeUpdate(insert_query);
           // dbConnection.statement.exeS

        } catch (SQLException e) {

            System.out.println("  ==> " + e);

        }
        
        
    }
    
}
