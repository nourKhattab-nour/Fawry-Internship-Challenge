/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawryproject;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Customer {

    private String customerName;
    private float customerBalance;
    private ArrayList<Product> availableProducts;
    private ArrayList<CartItem> cart;

    //Constructors
    public Customer(String customerName, float customerBalance, ArrayList<Product> availableProducts, ArrayList<CartItem> cart) {
        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.availableProducts = availableProducts;
        this.cart = new ArrayList<>();
    }

    public Customer(String customerName, float customerBalance, ArrayList<Product> availableProducts) {
        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.availableProducts = availableProducts;
        this.cart = new ArrayList<>(); // ADD THIS LINE - was missing!
    }

    //Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerBalance(float customerBalance) {
        this.customerBalance = customerBalance;
    }

    public void setAvailableProducts(ArrayList<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    //Getters
    public String getCustomerName() {
        return customerName;
    }

    public float getCustomerBalance() {
        return customerBalance;
    }

    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    //Functions
    //This function helps customer to add products with quantity
    public void add(Product product, int quantity) {

        if (product.getProductQuanity() < quantity) {                                             // Check if product exists and has enough stock
            System.out.println("Error: Not enough stock for " + product.getProductName());
            return;
        }

        boolean found = false;                                                                   // Check if product already exists in cart
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            if (item.getProduct() == product) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(product, quantity));
        }

        System.out.println("Added " + quantity + " of " + product.getProductName() + " to cart");
    }

    // This function allows customer to checkout process after adding products to the cart
    public void checkout() {

        if (cart.size() == 0) {
            System.out.println("Error: Cannot checkout with empty cart");
            return;
        }

        double subtotal = 0;
        ArrayList<Shippable> shippableItems = new ArrayList<>();

        for (int i = 0; i < cart.size(); i++) {                                                   // Check stock and calculate subtotal using traditional for loop
            CartItem cartItem = cart.get(i);
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            if (product.getProductQuanity() < quantity) {
                System.out.println("Error: Product " + product.getProductName() + " is out of stock");
                return;
            }

            subtotal += product.getProductPrice() * quantity;

            if (product instanceof Shippable) {                                                  // Add to shipping if applicable
                for (int j = 0; j < quantity; j++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }

        double shippingFees = 0;                                                                // Calculate shipping fees
        for (int i = 0; i < shippableItems.size(); i++) {
            Shippable item = shippableItems.get(i);
            shippingFees += item.getWeight() * 0.5 / 1000; // Convert grams to kg and multiply by $0.5
        }

        double total = subtotal + shippingFees;

        if (customerBalance < total) {                                                         // Check balance
            System.out.println("Error: Insufficient balance. Needed: $" + total
                    + ", Available: $" + customerBalance);
            return;
        }

        if (shippableItems.size() > 0) {
            ShippingService.ship(shippableItems);
        }

        for (int i = 0; i < cart.size(); i++) {
            CartItem cartItem = cart.get(i);
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            product.setProductQuanity(product.getProductQuanity() - quantity);
        }

        customerBalance -= total;                                                             // Process payment

        System.out.println("** Checkout receipt **");
        for (int i = 0; i < cart.size(); i++) {
            CartItem cartItem = cart.get(i);
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            System.out.println(quantity + "x " + product.getProductName() + "\t\t" + (int) (product.getProductPrice() * quantity));
        }
        System.out.println("--------------------");
        System.out.println("Subtotal\t\t" + (int) subtotal);
        System.out.println("Shipping\t\t" + (int) shippingFees);
        System.out.println("Amount\t\t\t" + (int) total);

        cart.clear();

    }

}
