package com.shakil.salesMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shakil
 */
public class Check {

    private int priceId;
    String quentity;
    String price;
    String cQty;

    int qty;
    int id;
    int retprice;
    int tbleId;
    int currentQty;

    public Boolean QtyCheck(int qty, String id) {

       // this.id = Integer.parseInt(id);

        System.out.println(" id of check = > " + this.id);

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String qty_query = "SELECT current_qty from product WHERE code ='" + id + "'";

            ResultSet rs = dbConnection.statement.executeQuery(qty_query);

            while (rs.next()) {
                this.quentity = rs.getString("current_qty");
                System.out.println("  this.quentity  " + this.quentity);

            }

            System.out.println("quentity found = > " + this.quentity);

            this.qty = Integer.parseInt(this.quentity);

        } catch (SQLException e) {

            System.out.println(" Qty check " + e);
        }

        if (qty <= this.qty) {
            return true;
        } else {
            return false;
        }

    }

    //============================================ price =======================================
    public int FindPrice(String id) {

        //this.priceId = Integer.parseInt(id);

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String price_query = "SELECT * from product WHERE code ='" + id + "'";

            ResultSet rs = dbConnection.statement.executeQuery(price_query);

            while (rs.next()) {
                this.price = rs.getString("price");

            }

            //  System.out.println("Price found = > " + this.price);
            this.retprice = Integer.parseInt(this.price);
        } catch (SQLException e) {

            System.out.println(" Check class  :: " + e);
        }
        return this.retprice;

    }

    public int findCurrentQty(String select_id) {

       // this.tbleId = Integer.parseInt(select_id);

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String price_query = "SELECT current_qty from product WHERE code ='" + select_id + "'";

            ResultSet rs = dbConnection.statement.executeQuery(price_query);

            while (rs.next()) {
                this.cQty = rs.getString("current_qty");

            }

            System.out.println("CurrentQty found = > " + this.cQty);
            this.currentQty = Integer.parseInt(this.cQty);
        } catch (SQLException e) {

            System.out.println(" FindCurrentQty = > " + e);
        }
        return this.currentQty;

    }

} // Class End 
