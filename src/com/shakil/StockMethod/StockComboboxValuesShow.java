

package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Shakil
 */
public class StockComboboxValuesShow {
    private String table;
    
    
     public void showComboBoxvalues(JComboBox NameCombobox, String table) {
        int sum = 0;
        this.table = table;

        try {
            DatabaseConnection dbConnector = new DatabaseConnection();
            // String insertStudentQuery = "INSERT INTO student " + "VALUES ('" + studentId + "', '" + name + "', '" + phone + "')";
            String product_name_list_query = "SELECT "+this.table+"_name FROM " + this.table;

            ResultSet rs = dbConnector.statement.executeQuery(product_name_list_query);

            List arraylist = new ArrayList();
            while (rs.next()) {
                //Retrieve by column name
                // String product_name = rs.getString("product_name");
                arraylist.add(rs.getString(1));

                System.out.println("product_name => : " + arraylist.toString());

            }

            // Here start combobox work .....
            NameCombobox.setModel(new DefaultComboBoxModel(arraylist.toArray()));

            NameCombobox.insertItemAt("select item ", 0);
            NameCombobox.setSelectedIndex(0);
            NameCombobox.toString();

            rs.close();

        } catch (SQLException e) {

            System.out.println("" + e);

        }

    } // combobox method end 
    
}
