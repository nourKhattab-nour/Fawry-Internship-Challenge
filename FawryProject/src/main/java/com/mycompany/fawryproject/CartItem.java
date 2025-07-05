/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryproject;

/**
 *
 * @author DELL
 */
public class CartItem {

    private Product product;
    private int quantity;
    //Constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    //Setters
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
