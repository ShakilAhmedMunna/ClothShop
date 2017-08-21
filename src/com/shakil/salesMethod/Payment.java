/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shakil.salesMethod;

/**
 *
 * @author Shakil
 */
public class Payment {
    
    public int calculation(int subTotal,int discount , int vat){
        
        System.out.println(" "  + subTotal +" " + discount +" " + vat);
        int x = (subTotal * vat) / 100;
        int y = subTotal + x;
        int z = y - discount;
        
        System.out.println("z " + z +" " + x);
        
        return z;   
    
    }

}
