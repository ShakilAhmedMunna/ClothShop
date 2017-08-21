package com.shakil.salesMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Shakil
 */
public class SalesProduct {

    String code;
    String qty;
    String price;

    public void salesInsert() {

        String o_code;
        String o_qty;
        String o_price;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            Date date = new Date();
            final String SalesCode = new SimpleDateFormat("yy-MMdHHssSmSHss").format(date);
      
            
            
            String price_sum_query = "SELECT * FROM `order`";
            try (ResultSet rs = dbConnection.statement.executeQuery(price_sum_query)) {
                while (rs.next()) {

                    o_code = rs.getString("order_code");
                    o_qty = rs.getString("order_qty");
                    o_price = rs.getString("order_price");
                    
                    System.out.println(" sales code " + SalesCode);
                    this.insertdata(o_code, o_price, o_qty , SalesCode);

                }
            }

        } catch (SQLException e) {
            
            System.out.println("sales product " + e);

        }

    }

    private void insertdata(String code, String price, String qty , String SalesCode) {

        this.code = code;
        this.qty = qty;
        this.price = price;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            Date date = new Date();

            String d = new SimpleDateFormat("yy-MM-dd").format(date);

           // String insert_query = "INSERT INTO `clothsshop`.`sales` (`code`,`sales_qty`, `sales_price`, `sales_date`) VALUES ('" + this.code + "', '" + this.qty + "', '" + this.price + "','" + d + "')";
           String insert_query = "INSERT INTO `clothemanagementsshop`.`sales` (`sales_code`, `product_code`, `qty`, `price`, `date`) VALUES ('"+ SalesCode +"', '"+this.code+"', '"+this.qty+"', '"+ this.price+"', '" + d +"')";
            dbConnection.statement.executeUpdate(insert_query);

        } catch (SQLException e) {
            System.out.println("insert sales product info here error " + e);
        }

        System.out.println(" order ---->>>>" + this.code + " " + this.qty + " " + this.price);

    }

    public void delete() {

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String query = "TRUNCATE TABLE `order`";
            dbConnection.statement.executeUpdate(query);

        } catch (SQLException e) {

            System.out.println("error delete " + e);
        }

    }

}
