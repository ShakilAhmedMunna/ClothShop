package com.shakil.salesMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shakil
 */
public class SumOrderPrice {

    String p;
    int price;
    int sum;

    public int ordeSum() {
        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String price_sum_query ="SELECT * FROM `order`";

            ResultSet rs = dbConnection.statement.executeQuery(price_sum_query);
             sum = 0;
            while (rs.next()) {

                System.out.println("Sum " + sum);
                p = rs.getString("order_price");
               price = Integer.parseInt(p);
               sum += price;
                //System.out.println(" ====================> "  + p);
            }

            //System.out.println("ordeSum() =========================== > " + sum);
             rs.close();

        } catch (SQLException e) {

            System.out.println(" ordeSum() =================================> " + e);
        }
        
       // System.out.println("return    " + sum);
 
        return sum;
    }
}
