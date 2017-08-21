package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Shakil
 */
public class StockInfoAdd {

    String StockLocation;
    String StockDescription = null;
    int id;

    public void newStockAdd(String location, String description) {

        this.StockLocation = location;
        this.StockDescription = description;

        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Date date = new Date();
            String d = new SimpleDateFormat("yy-MM-dd").format(date);

            String Stock_insert_query = "INSERT INTO `clothemanagementsshop`.`stock` (`location`, `date`, `description`) VALUES ('" + this.StockLocation + "', '" + d + "', '" + this.StockDescription + "')";
            dbConnection.statement.executeUpdate(Stock_insert_query);

        } catch (SQLException e) {
            System.out.println("StockInfoAdd " + e);
        }

        //return 0;
    }

    public void StockComboShow(JComboBox LocationCombobox) {

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

            String location_list_query = "SELECT location FROM `stock`";

            ResultSet rs = dbConnector.statement.executeQuery(location_list_query);

            List arraylist = new ArrayList();
            while (rs.next()) {
                //Retrieve by column name
                // String product_name = rs.getString("product_name");
                arraylist.add(rs.getString(1));

               // System.out.println("product_name => : " + arraylist.toString());
            }

            // Here start combobox work .....
            LocationCombobox.setModel(new DefaultComboBoxModel(arraylist.toArray()));

            LocationCombobox.insertItemAt("select item ", 0);
            LocationCombobox.setSelectedIndex(0);
            LocationCombobox.toString();

            rs.close();

        } catch (SQLException e) {

            System.out.println("" + e);

        }

    }

    public void StockDesignComboShow(JComboBox combobox, String name, String table) {

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

            String product_name_list_query = "SELECT " + name + " FROM " + table;

            ResultSet rs = dbConnector.statement.executeQuery(product_name_list_query);

            List arraylist = new ArrayList();
            while (rs.next()) {
                //Retrieve by column name
                // String product_name = rs.getString("product_name");
                arraylist.add(rs.getString(1));

               // System.out.println("product_name => : " + arraylist.toString());
            }

            // Here start combobox work .....
            combobox.setModel(new DefaultComboBoxModel(arraylist.toArray()));

            combobox.insertItemAt("select item ", 0);
            combobox.setSelectedIndex(0);
            combobox.toString();

            rs.close();

        } catch (SQLException e) {

            System.out.println("" + e);

        }

    }

    public int MaxValue(String colom, String table) {

        int id;
        try {
            DatabaseConnection dbConnector = new DatabaseConnection();

            //String maxID = "SELECT MAX("+colom+") FROM "+table;
            String maxID = "SELECT MAX(product_info_id) FROM product_info";
            //  SELECT MAX(product_info_id) FROM product_info;
            System.out.println("  max id - > " + maxID);

            ResultSet rs = dbConnector.statement.executeQuery(maxID);
//
            while (rs.next()) {
               // String replyColom = rs.getString(colom);
                int replyColom = rs.getInt(1);
                this.id = replyColom;
            }

           //replyColom = rs.getString(colom);
            // id = Integer.parseInt(replyColom);
            rs.close();

        } catch (SQLException e) {

            System.out.println("Max  ==" + e);

        }
       // this.id = Integer.parseInt(replyColom);
        return this.id;

    }

    public int insertProductInfo(String mc, String size, String thread, String type, String select) {

        int reply = 0;
        // new stockIdFinder.findId("m_c_id", "manufacture_country","m_c_name", mc);
        StockIdFinder stockIdFinder = new StockIdFinder();
        int m = stockIdFinder.findId("m_c_id", "manufacture_country", "m_c_name", mc);
        int s = stockIdFinder.findId("size_id", "size", "size_name", size);
        int t = stockIdFinder.findId("thread_id", "thread", "thread_name", thread);
        int ty = stockIdFinder.findId("type_id", "type", "type_name", type);

        try {
            DatabaseConnection dbConnection = new DatabaseConnection();

            String Stock_insert_query = "INSERT INTO `clothemanagementsshop`.`product_info` (`m_c_id`, `type_id`, `size_id`, `thread_id`) VALUES ('" + m + "', '" + ty + "', '" + s + "', '" + t + "')";
            dbConnection.statement.executeUpdate(Stock_insert_query);
            reply = this.MaxValue("product_info_id", "product_info");
            System.out.println("reply  Id : " + reply);
        } catch (SQLException e) {
            System.out.println("product_info  " + e);
        }

//        System.out.println(" IDDDDD  " + m);
//         System.out.println(" IDDDDD  " + s);
//          System.out.println(" IDDDDD  " + t);
//           System.out.println(" IDDDDD  " + ty);
        return reply;
    }

}
