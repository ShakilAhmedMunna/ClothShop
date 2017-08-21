package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shakil
 */
public class StockValuesShow {

    JTable table;

    public void show(JTable table) {

        this.table = table;

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String show_query = "select code , manufacture_country.m_c_name as Manufacture,type_name as TypeName ,size.size_name as Size , thread.thread_name as Thread , product.price as Price , product.current_qty as currentQty from product inner join product_info on product.product_info_id = product_info.product_info_id inner join manufacture_country on product_info.m_c_id = manufacture_country.m_c_id inner join size on  product_info.size_id = size.size_id inner join type on  product_info.type_id = type.type_id inner join thread on  product_info.thread_id = thread.thread_id";

            ResultSet rs = dbConnection.statement.executeQuery(show_query);

            this.table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

        }

    }

    public void todayShow(JTable jtable) {

       // this.inputId =Integer.parseInt(input);
     //   System.out.println(input + "Show table id Show jtable ---- > ?? ");
        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String show_query;
            show_query = "select sales.sales_code as SalesCode ,sales.product_code as ProductCode , type.type_name as TypeName ,sales.price as Price , date as Date from sales inner join product on sales.product_code = product.code inner join product_info on product.product_info_id = product_info.product_info_id inner join type on product_info.type_id = type.type_id where sales.date = '2016-12-09' order by sales.date DESC";
            ResultSet rs = dbConnection.statement.executeQuery(show_query);
//CURDATE()
            jtable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

            System.out.println(" error = > " + e);

        }

    }

    public void SalesListShow(JTable jtable) {

       // this.inputId =Integer.parseInt(input);
      //  System.out.println(input + "Show table id Show jtable ---- > ?? ");
        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String show_query = "select sales_code as SalesCode ,product_code as ProductCode ,qty as Quentity ,price as Price , date as Date from sales order by date DESC";

            ResultSet rs = dbConnection.statement.executeQuery(show_query);

            jtable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

            System.out.println(" error = > " + e);

        }

    }

}
