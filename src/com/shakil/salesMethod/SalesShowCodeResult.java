package com.shakil.salesMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shakil
 */
public class SalesShowCodeResult {

    String inputs;
    int inputId;

    public void Show(String input, JTable jtable) {

       // this.inputId =Integer.parseInt(input);
        
        System.out.println(input + "Show table id Show jtable ---- > ?? ");

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String show_query ="select code , manufacture_country.m_c_name as Manufacture, size.size_name as Size , thread.thread_name as Thread , product.price as Price , product.current_qty as currentQty from product inner join product_info on product.product_info_id = product_info.product_info_id inner join manufacture_country on product_info.m_c_id = manufacture_country.m_c_id inner join size on  product_info.size_id = size.size_id inner join thread on  product_info.thread_id = thread.thread_id where product.code = '" + input + "'";

            ResultSet rs = dbConnection.statement.executeQuery(show_query);

            jtable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

            System.out.println(" error = > " + e);

        }

    }
    
    
    
    
    public void SalesShow(JTable jtable) {

       // System.out.println("order bro !!!");

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String show_query = "SELECT order_id as Serial, order_code as Code ,order_qty as Quentity , order_price as Price FROM `order`";

            ResultSet rs = dbConnection.statement.executeQuery(show_query);

            jtable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            System.out.println(" error = > " + e);

        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
