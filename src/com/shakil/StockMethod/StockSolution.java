package com.shakil.StockMethod;

import com.shakil.DatabaseConnection.DatabaseConnection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Shakil
 */
public class StockSolution {

    String material;
    String product;
    String size;
    int purchage;
    int price;
    int Qty;
    int materialId;
    int productId;
    int sizeId;

    public void StockInsert(String material, String product, String size, int purchage, int price, int Qty) {
        this.material = material;
        this.product = product;
        this.size = size;
        this.purchage = purchage;
        this.price = price;
        this.Qty = Qty;

        System.out.println(" m " + this.material);

        StockIdFinder stockIdFinder = new StockIdFinder();

        this.materialId = stockIdFinder.findId("material_id", "material", "material_name", this.material);
        this.productId = stockIdFinder.findId("product_id", "product", "product_name", this.product);
        this.sizeId = stockIdFinder.findId("size_id", "size", "size_name", this.size);

        try {

            DatabaseConnection dbConnection = new DatabaseConnection();

            Date date = new Date();
            String d = new SimpleDateFormat("yy-MM-dd").format(date);

            String insert_query = "INSERT INTO `clothsshop`.`stock_info` (`stock_name`, `stock_product`, `stock_size`, `stock_qty`, `stock_purchage`, `stock_price`, `stock_date`, `stock_current_qty`) VALUES ('" + this.materialId + "', '" + this.productId + "', '" + this.sizeId + "', '" + Qty + "', '" + purchage + "', '" + price + "', '" + d + "', '"+Qty+"')";
            dbConnection.statement.executeUpdate(insert_query);
            
            
            System.out.println(" Id of material is " + this.materialId);
            System.out.println(" Id of product is " + this.productId);
            System.out.println(" Id of size is " + this.sizeId);

        } catch (SQLException e) {
            System.out.println(" " + e);
        }

    }

   

   

}
