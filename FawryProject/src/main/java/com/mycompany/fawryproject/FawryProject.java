/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fawryproject;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class FawryProject {

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("    E-COMMERCE SYSTEM COMPREHENSIVE TEST");
        System.out.println("===============================================");
        System.out.println();

        ArrayList<Product> availableProducts = initializeProducts();

//        // Display initial product catalog
//        displayProductCatalog(availableProducts);
//        
//        // Test 1: Product Creation and Properties
//            testProductCreation();
//        
//        // Test 2: Customer Creation
//        testCustomerCreation(availableProducts);
//        
//        // Test 3: Cart Operations
//        testCartOperations(availableProducts);
//        
//        // Test 4: Checkout Success Scenarios
//        testSuccessfulCheckouts(availableProducts);
//        
//        // Test 5: Checkout Error Scenarios
//        testCheckoutErrors(availableProducts);
//        
//        // Test 6: Shipping Service
//        testShippingService();
//        
        System.out.println("===============================================");
        System.out.println("===============================================");
    }

    /**
     * Initialize all types of products for testing
     */
    private static ArrayList<Product> initializeProducts() {
        ArrayList<Product> products = new ArrayList<>();

        // Expiring & Shippable products
        products.add(new ExpiringProduct("2025-12-31", 500.0f, "Cheese", 1, 25.99f, 15));
        products.add(new ExpiringProduct("2025-08-15", 300.0f, "Biscuits", 2, 12.50f, 25));
        products.add(new ExpiringProduct("2025-07-10", 200.0f, "Milk", 3, 5.99f, 30));

        // Non-expiring & Shippable products  
        products.add(new NonExpiringProduct(5000.0f, "TV", 4, 299.99f, 8));
        products.add(new NonExpiringProduct(800.0f, "Mobile Phone", 5, 199.99f, 12));
        products.add(new NonExpiringProduct(150.0f, "Headphones", 6, 49.99f, 20));

        // Non-shippable products
        products.add(new NonShippableProduct("Mobile Scratch Card", 7, 10.00f, 100));
        products.add(new NonShippableProduct("Digital Gift Card", 8, 25.00f, 50));
        products.add(new NonShippableProduct("Software License", 9, 99.99f, 25));

        return products;
    }

    /**
     * Test 1: Product Creation and Properties
     */
    private static void testProductCreation() {
        System.out.println("=== TEST 1: PRODUCT CREATION AND PROPERTIES ===");
        
        // Test ExpiringProduct
        ExpiringProduct cheese = new ExpiringProduct("2025-12-31", 500.0f, "Cheese", 100, 20.0f, 10);
        System.out.println("Created ExpiringProduct: " + cheese.getProductName());
        System.out.println("- Price: $" + cheese.getProductPrice());
        System.out.println("- Quantity: " + cheese.getProductQuanity());
        System.out.println("- Weight: " + cheese.getWeight() + "g");
        System.out.println("- Expiry: " + cheese.getExpiryDate());
        System.out.println("- Shippable Name: " + cheese.getName());
        
        // Test NonExpiringProduct  
        NonExpiringProduct tv = new NonExpiringProduct(3000.0f, "TV", 101, 150.0f, 5);
        System.out.println("\nCreated NonExpiringProduct: " + tv.getProductName());
        System.out.println("- Price: $" + tv.getProductPrice());
        System.out.println("- Quantity: " + tv.getProductQuanity());
        System.out.println("- Weight: " + tv.getWeight() + "g");
        System.out.println("- Shippable Name: " + tv.getName());
        
        // Test NonShippableProduct
        NonShippableProduct card = new NonShippableProduct("Card", 102, 15.0f, 50);
        System.out.println("\nCreated NonShippableProduct: " + card.getProductName());
        System.out.println("- Price: $" + card.getProductPrice());
        System.out.println("- Quantity: " + card.getProductQuanity());
        System.out.println("- Shippable: No");
        
        System.out.println("\n✓ Product creation test completed\n");
    }
//    /**
//     * Test 2: Customer Creation
//     */
    private static void testCustomerCreation(ArrayList<Product> products) {
        System.out.println("=== TEST 2: CUSTOMER CREATION ===");
        
        // Test customer with cart parameter
        ArrayList<CartItem> initialCart = new ArrayList<>();
        Customer customer1 = new Customer("Nour khattab", 1000.0f, products, initialCart);
        System.out.println("Created customer: " + customer1.getCustomerName());
        System.out.println("- Balance: $" + customer1.getCustomerBalance());
        
        
        // Test customer without cart parameter
        Customer customer2 = new Customer("Ahmed", 500.0f, products);
        System.out.println("\nCreated customer: " + customer2.getCustomerName());
        System.out.println("- Balance: $" + customer2.getCustomerBalance());
        
        
        System.out.println("\n✓ Customer creation test completed\n");
    }
    
//    /**
//     * Test 3: Cart Operations
//     */
    private static void testCartOperations(ArrayList<Product> products) {
        System.out.println("=== TEST 3: CART OPERATIONS ===");
        
        Customer customer = new Customer("Cart Tester", 1000.0f, products);
        
        // Test adding products to cart
        System.out.println("3.1 Adding products to cart:");
        customer.add(products.get(0), 2); // Cheese
        customer.add(products.get(1), 3); // Biscuits
        customer.add(products.get(3), 1); // TV
        customer.add(products.get(6), 5); // Mobile Scratch Card
       
        
        // Test adding same product again (should update quantity)
        System.out.println("\n3.2 Adding same product again:");
        customer.add(products.get(0), 1); // Add more cheese
        
        
        // Test adding more than available stock
        System.out.println("\n3.3 Testing stock validation:");
        customer.add(products.get(0), 50); // Try to add 50 cheese (only 15 available)
        
        
        System.out.println("\n✓ Cart operations test completed\n");
    }
    ////    
//    /**
//     * Test 4: Successful Checkout Scenarios
//     */
    private static void testSuccessfulCheckouts(ArrayList<Product> products) {
        System.out.println("=== TEST 4: SUCCESSFUL CHECKOUT SCENARIOS ===");

        // Test 4.1: Checkout with mixed products (shippable + non-shippable)
        System.out.println("4.1 Mixed products checkout:");
        Customer customer1 = new Customer("Mixed Buyer", 500.0f, products);
        customer1.add(products.get(0), 2); // Cheese (shippable, expiring)
        customer1.add(products.get(1), 1); // Biscuits (shippable, expiring)
        customer1.add(products.get(3), 1); // TV (shippable, non-expiring)
        customer1.add(products.get(6), 3); // Mobile cards (non-shippable)
        customer1.checkout();
        // Test 4.2: Checkout with only shippable products
        System.out.println("4.2 Only shippable products checkout:");
        Customer customer2 = new Customer("Shipping Customer", 400.0f, products);
        customer2.add(products.get(0), 1); // Cheese
        customer2.add(products.get(4), 1); // Mobile Phone
        customer2.checkout();
        
        // Test 4.3: Checkout with only non-shippable products
        System.out.println("4.3 Only non-shippable products checkout:");
        Customer customer3 = new Customer("Digital Customer", 200.0f, products);
        customer3.add(products.get(6), 5); // Mobile cards
        customer3.add(products.get(7), 2); // Digital gift cards
        customer3.checkout();
        
        // Test 4.4: Large quantity checkout
        System.out.println("4.4 Large quantity checkout:");
        Customer customer4 = new Customer("Bulk Buyer", 1000.0f, products);
        customer4.add(products.get(1), 5); // 5 Biscuits
        customer4.add(products.get(5), 3); // 3 Headphones
        customer4.add(products.get(8), 5); // 5 Software licenses
        customer4.checkout();
        
        System.out.println("✓ Successful checkout scenarios completed\n");
    }
    
//    /**
//     * Test 5: Checkout Error Scenarios
//     */
    private static void testCheckoutErrors(ArrayList<Product> products) {
        System.out.println("=== TEST 5: CHECKOUT ERROR SCENARIOS ===");
        
//      Test 5.1: Empty cart checkout
   
        System.out.println("5.1 Empty cart checkout:");
        Customer customer1 = new Customer("Empty Cart", 1000.0f, products);
        customer1.checkout();
        
        // Test 5.2: Insufficient balance
        System.out.println("5.2 Insufficient balance checkout:");
        Customer customer2 = new Customer("Poor Customer", 50.0f, products);
        customer2.add(products.get(3), 1); // TV costs $299.99
        customer2.checkout();
        
        // Test 5.3: Out of stock (after previous purchases)
        System.out.println("5.3 Out of stock checkout:");
        Customer customer3 = new Customer("Late Customer", 1000.0f, products);
        customer3.add(products.get(0), 20); // Try to buy 20 cheese (stock reduced by previous tests)
        customer3.checkout();
        
        // Test 5.4: Exactly insufficient balance (edge case)
        System.out.println("5.4 Exactly insufficient balance:");
        Customer customer4 = new Customer("Precise Customer", 25.98f, products);
        customer4.add(products.get(0), 1); // Cheese costs $25.99 + potential shipping
        customer4.checkout();
        
        System.out.println("✓ Checkout error scenarios completed\n");
    }
//    
//    /**
//     * Test 6: Shipping Service
//     */
    
    private static void testShippingService() {
        System.out.println("=== TEST 6: SHIPPING SERVICE ===");
        
        // Create different shippable items
        ArrayList<Shippable> shippableItems = new ArrayList<>();
        
        // Add multiple items of different types
        ExpiringProduct cheese = new ExpiringProduct("2025-12-31", 500.0f, "Cheese", 1, 25.99f, 10);
        NonExpiringProduct tv = new NonExpiringProduct(5000.0f, "TV", 2, 299.99f, 5);
        ExpiringProduct biscuits = new ExpiringProduct("2025-08-15", 300.0f, "Biscuits", 3, 12.50f, 20);
        
        // Add multiple quantities
        shippableItems.add(cheese);
        shippableItems.add(cheese); // 2 cheese
        shippableItems.add(tv);     // 1 TV
        shippableItems.add(biscuits);
        shippableItems.add(biscuits);
        shippableItems.add(biscuits); // 3 biscuits
        
        System.out.println("Testing shipping service with multiple items:");
        ShippingService.ship(shippableItems);
        
        // Test with empty shipping
        System.out.println("Testing shipping service with empty list:");
        ArrayList<Shippable> emptyList = new ArrayList<>();
        ShippingService.ship(emptyList);
        
        System.out.println("✓ Shipping service test completed\n");
    }
    

//    /**
//     * Display initial product catalog
//     */
    
    private static void displayProductCatalog(ArrayList<Product> products) {
        System.out.println("=== INITIAL PRODUCT CATALOG ===");
        System.out.println("ID\tName\t\t\tPrice\tStock\tType\t\t\tWeight\tExpiry");
        System.out.println("--------------------------------------------------------------------------------");

        for (Product product : products) {
            String type = "";
            String weight = "N/A";
            String expiry = "N/A";

            if (product instanceof ExpiringProduct) {
                ExpiringProduct ep = (ExpiringProduct) product;
                type = "Expiring+Shippable";
                weight = ep.getWeight() + "g";
                expiry = ep.getExpiryDate();
            } else if (product instanceof NonExpiringProduct) {
                NonExpiringProduct nep = (NonExpiringProduct) product;
                type = "Non-Expiring+Shippable";
                weight = nep.getWeight() + "g";
            } else if (product instanceof NonShippableProduct) {
                type = "Non-Shippable";
                weight = "0g";
            }

            System.out.printf("%d\t%-20s\t$%.2f\t%d\t%-20s\t%s\t%s%n",
                    product.getProductID(),
                    product.getProductName(),
                    product.getProductPrice(),
                    product.getProductQuanity(),
                    type,
                    weight,
                    expiry);
        }
        System.out.println();
    }

}
