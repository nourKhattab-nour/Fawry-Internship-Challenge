/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryproject;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class NonExpiringProduct extends Product implements Shippable{
    
    private double weight;

    //constructor
    public NonExpiringProduct(float weight, String productName, int productID, float productPrice, int productQuanity) {
        super(productName, productID, productPrice, productQuanity);
        this.weight = weight;
    }
    //Setters
    public void setWeight(float weight) {
        this.weight = weight;
    }

    //Getters
    public double getWeight() {
        return weight;
    }
    
    @Override
    public String getName(){
        return getProductName();
    }
    
    
}
