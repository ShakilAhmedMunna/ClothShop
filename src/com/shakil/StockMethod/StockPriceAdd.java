package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import com.shakil.StockBean.StockProductInfoBean;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Shakil
 */
public class StockPriceAdd {

    public void priceadd(StockProductInfoBean stockProductInfoBean) {
        StockProductInfoBean StockProductInfoBean = new StockProductInfoBean();
        StockProductInfoBean = stockProductInfoBean;
         StockIdFinder idfind = new StockIdFinder();
        System.out.println(" name  select  = > " + StockProductInfoBean.select);

        StockProductInfoBean.selectId = idfind.findId("stock_id", "stock", "location", StockProductInfoBean.select);
        
        StockInfoAdd stockInfoAdd = new StockInfoAdd();
        StockProductInfoBean.productinfoId = stockInfoAdd.insertProductInfo(stockProductInfoBean.manufacture, stockProductInfoBean.size, stockProductInfoBean.thread, stockProductInfoBean.type, stockProductInfoBean.select);



        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Date date = new Date();
        String productserial = new SimpleDateFormat("yy-MMdHHssSmS").format(date);
        String d = new SimpleDateFormat("yy-MM-dd").format(date);

            
            
          //  String code = new SimpleDateFormat("yy-MM-dd").format(date);

            String Stock_insert_query = "INSERT INTO `clothemanagementsshop`.`product` (`code`, `product_info_id`, `purchase`, `price`, `qty`, `current_qty`, `p_date`, `stock_id`) VALUES ('"+StockProductInfoBean.size +""+StockProductInfoBean.code+""+productserial + "', '" + StockProductInfoBean.productinfoId + "', '" + stockProductInfoBean.purchage + "', '" + stockProductInfoBean.price + "', '" + stockProductInfoBean.qty + "', '" + stockProductInfoBean.qty + "', '" + d + "', '" + StockProductInfoBean.selectId+ "')";
           dbConnection.statement.executeUpdate(Stock_insert_query);

        } catch (Exception e) {
            System.out.println("StockInfoAdd " + e);
        }
    }
}
