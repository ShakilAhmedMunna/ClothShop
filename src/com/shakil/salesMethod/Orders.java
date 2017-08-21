package com.shakil.salesMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import com.shakil.StockBean.StockProductInfoBean;
import com.shakil.StockMethod.StockIdFinder;
import com.shakil.StockMethod.StockInfoAdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Shakil
 */
public class Orders {

    String order_query;
    String updateQty_query;
    int totalprice;

    public void orderAdded(String select_id, int retprice, int OrdernewQty) {

        //System.out.println(" " + select_id + " " + retprice + " " + OrdernewQty);
        this.totalprice = retprice * OrdernewQty;
        System.out.println(" hey order :---- " + this.totalprice);

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

            order_query = "INSERT INTO `clothemanagementsshop`.`order` (`order_code`, `order_qty`, `order_price`) VALUES ( '" + select_id + "', '" + OrdernewQty + "', '" + this.totalprice + "')";
            dbConnector.statement.executeUpdate(order_query);
            JOptionPane.showMessageDialog(null, "ADDED");

        } catch (SQLException e) {

            System.out.println("order class = > " + e);

        }

    }

    public void QtyUpdate(String CodeId, int orderQty, int currentQty) {

        int updateQty = currentQty - orderQty;

        System.out.println("Sales item qty number : " + updateQty);

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

           // updateQty_query = "UPDATE clothemanagementsshop`.`product` SET `current_qty` = '" + updateQty + "' WHERE `product`.`code` = '" + CodeId + "'";
            updateQty_query = "UPDATE `clothemanagementsshop`.`product` SET `current_qty` = '" + updateQty + "' WHERE `product`.`code` = '" + CodeId + "'";

            dbConnector.statement.executeUpdate(updateQty_query);

        } catch (SQLException e) {

            System.out.println("Order class Update current qty= > " + e);

        }

    }

    public void orderDelete(String id) {

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

           // updateQty_query = "UPDATE clothemanagementsshop`.`product` SET `current_qty` = '" + updateQty + "' WHERE `product`.`code` = '" + CodeId + "'";
            String DELETE = "DELETE FROM `clothemanagementsshop`.`order` WHERE `order`.`order_id` = '" + id + "'";

            dbConnector.statement.executeUpdate(DELETE);

        } catch (SQLException e) {

            System.out.println("Order class DELETE current qty= > " + e);

        }

    }

    public String findId(String id) {

        String retId = null;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String id_query = "SELECT `order_code` FROM `order` WHERE order_id='" + id + "'";

            ResultSet rs = dbConnection.statement.executeQuery(id_query);
            try {

                while (rs.next()) {
                    retId = rs.getString("order_code");

                }
            } catch (SQLException e) {

                System.out.println(" 1st ---- >> " + e);
            }

        } catch (Exception e) {
            System.out.println(" rfdlkfldkglkdf => " + e);
        }

        return retId;
    }

    public int findQty(String id) {

        String retQty;
        int returnQty = 0;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String id_query = "SELECT `order_qty` FROM `order` WHERE order_id='" + id + "'";

            ResultSet rs = dbConnection.statement.executeQuery(id_query);
            try {

                while (rs.next()) {
                    retQty = rs.getString("order_qty");
                    returnQty = Integer.parseInt(retQty);
                }
            } catch (SQLException e) {

                System.out.println(" 1st ---- >> " + e);
            }

        } catch (Exception e) {
            System.out.println(" returnId => " + e);
        }

        return returnQty;
    }
    
    public int currentQty(String id) {

        String retQty;
        int returnQty = 0;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String id_query = "SELECT `current_qty` FROM `product` WHERE `code` = '"+id+"'";

            ResultSet rs = dbConnection.statement.executeQuery(id_query);
            try {

                while (rs.next()) {
                    retQty = rs.getString("current_qty");
                    returnQty = Integer.parseInt(retQty);
                }
            } catch (SQLException e) {

                System.out.println(" 1st ---- >> " + e);
            }

        } catch (Exception e) {
            System.out.println(" returnId => " + e);
        }

        return returnQty;
    }

    public void QtyUpdate(String id, int qty) {

        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
           int MyQty = qty + this.currentQty(id);
            String Stock_update_query = "UPDATE `clothemanagementsshop`.`product` SET `current_qty` = '" + MyQty + "' WHERE `product`.`code` = '" + id + "'";
            dbConnection.statement.executeUpdate(Stock_update_query);

        } catch (SQLException e) {
            System.out.println("StockInfoAdd " + e);
        }
    }

}
