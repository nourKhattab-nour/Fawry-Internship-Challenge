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
public class Product {

    private String productName;
    private int productID;
    private float productPrice;
    private int productQuanity;

    //Constructor
    public Product(String productName, int productID, float productPrice, int productQuanity) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.productQuanity = productQuanity;
    }

    //Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuanity(int productQuanity) {
        this.productQuanity = productQuanity;
    }

    //Getters
    public String getProductName() {
        return productName;
    }

    public int getProductID() {
        return productID;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public int getProductQuanity() {
        return productQuanity;
    }

}
