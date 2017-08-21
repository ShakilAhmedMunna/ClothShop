/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shakil.print;

import com.shakil.DatabaseConnection.DatabaseConnection;
import com.shakil.beans.OrderBean;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Shakil
 */
public class PrintOrder {
  
    public ArrayList<OrderBean> Print() {

        //SELECT order_id as Serial, order_code as Code ,order_qty as Quentity , order_price as Price FROM `order`";
        
        ArrayList<OrderBean> orderBeans = new ArrayList<OrderBean>();
       
      
      // ArrayList<OrderBean[]> arrlist = new ArrayList<OrderBean[]>();
        
        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            String qty_query = "SELECT order_id , order_code ,order_qty  , order_price  FROM `order`";

            ResultSet rs = dbConnection.statement.executeQuery(qty_query);
            int count=0;
//           while (rs.next()) {
//                    String rrr = rs.getString("order_code");
//                    int  sss = rs.getInt("order_qty");
//                    int kkk = rs.getInt("order_price");
//                    
//                    System.out.println(" fhdkjfghfkdjghkdfjghkdfjhgkdfgjk" + rrr);
//                     System.out.println(" fhdkjfghfkdjghkdfjghkdfjhgkdfgjk" + sss);
//                      System.out.println(" fhdkjfghfkdjghkdfjghkdfjhgkdfgjk" + kkk);
//                }
            // orderBeans[count] = new OrderBean();
            while (rs.next()) {
                
                OrderBean ob = new OrderBean();
                 
              
                ob.setProductId(rs.getString("order_code"));
                ob.setQuantity(rs.getInt("order_qty"));
                
                ob.setPrice(rs.getInt("order_price"));
                
                System.out.println("------------From PrintOrder Class-----------");
                System.out.println("ProductId "+ob.getProductId()); 
                System.out.println("Quantitiy "+ob.getQuantity());
                System.out.println("price "+ob.getPrice());
                
                ob.setPrice(rs.getInt("order_price"));
                orderBeans.add(ob);
               count++;
            }
            
          //   orderBeans[count].setId(count);

        } catch (SQLException e) {

            System.out.println("   hhhh" + e);
        }

        return orderBeans;
    }

}
