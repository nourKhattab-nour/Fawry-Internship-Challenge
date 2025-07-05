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
class ExpiringProduct extends Product implements Shippable {

    private String expiryDate;
    private double weight;

    //Constructor
    public ExpiringProduct(String expiryDate, double weight, String productName, int productID, float productPrice, int productQuanity) {
        super(productName, productID, productPrice, productQuanity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    //Setters
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    //Getters
    public String getExpiryDate() {
        return expiryDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return getProductName();
    }

}
