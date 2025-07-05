# Fawry Internship Challenge - E-Commerce System

## System Overview
A robust e-commerce system managing products, customers, carts, and checkout processes with support for:
- Expirable/non-expirable products
- Shippable/non-shippable items
- Stock validation and shipping calculations
- Comprehensive error handling

## Core Components

- **`Product`**: Base class (`name`, `price`, `quantity`)
- **`ExpiringProduct`**: Adds `expiryDate` (perishable goods)
- **`NonExpiringProduct`**: Standard durable goods
- **`NonShippableProduct`**: Digital items
- **`Customer`**
- **`Shippable Interface `**
  
## Test 

<div align="center">
  <img src="https://github.com/user-attachments/assets/d168e378-3f7d-4705-a1b2-a99530dc4998" alt="Description" width="400">
</div>

This test checks an e-commerce system's property assignment and product generation features. A NonExpiring Product (TV) has price, quantity, and weight but no expiration date; a NonShippable Product (Card) has price and quantity but no shipping capability; and an Expiring Product (Cheese) has specific attributes like price, quantity, weight, and expiration date. The test makes sure the system manages various product categories

<div align="center">
  <img src="https://github.com/user-attachments/assets/ea41f4ff-99cd-4f88-904e-0af3c7e7b844" alt="Image 1" width="400" style="margin:10px">

This test focuses on customer creation and balance initialization in the e-commerce system. It verifies the successful creation of two customers: "Nour Khattab" with an initial balance of $1000.0 and "Ahmed" with $500.0. The test ensures that the system correctly handles customer account setup, including proper name assignment and initial balance configuration.

<img src="https://github.com/user-attachments/assets/94f90b4e-1ff8-4700-87b5-95ed53c60455" alt="Image 2" width="400" style="margin:10px">
</div>

This test evaluates cart operations in the e-commerce system, focusing on product additions, stock management, and error handling. It begins by successfully adding multiple products (Cheese, Biscuits, TV, and Mobile Scratch Card) in varying quantities to the cart. The test then verifies the system's ability to handle additional requests for the same product (Cheese) by incrementing its quantity. Finally, it checks stock validation by attempting to exceed available number which is 15 , triggering an appropriate error message ("Not enough stock for Cheese"). 

<div style="display: flex; justify-content: center; gap: 10px; flex-wrap: wrap;">
  <img src="https://github.com/user-attachments/assets/a95d0420-a3c4-41f9-ab26-f2213b682829" 
       style="width: 300px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/5b9a6637-3c48-4b27-a132-9c26f27df273" 
       style="width: 300px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/6c3d8465-9130-4f68-b18a-684b2a2479f5" 
       style="width: 300px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/4bb035b0-bee3-4688-bef6-620ba43b92b5" 
       style="width: 300px; height: 200px; object-fit: contain;">
</div>

These tests validate successful checkout scenarios in the e-commerce system, covering different product combinations and shipping conditions.
1.	Mixed Products Checkout (4.1):
o	Tests a cart containing both shippable (Cheese, Biscuits, TV) and non-shippable (Mobile Scratch Card) items.
o	Verifies correct weight calculation for shipping (6.3kg total) and proper receipt generation, including subtotal, shipping fees ($3), and final amount ($397).
2.	Non-Shippable Products Only (4.3):
o	Confirms checkout with only digital/non-physical items (Mobile Scratch Card, Digital Gift Card).
o	Ensures no shipping fees are applied, and the receipt accurately reflects the subtotal ($100) and final amount ($100).
3.	Large Quantity Checkout (4.4):
o	Validates handling of bulk orders (Biscuits, Headphones, Software License).
o	Checks partial shipment (only shippable Biscuits contribute to package weight: 1.5kg) and correct pricing, including waived shipping fees (possibly due to a promotion or digital dominance in the cart).

<div style="display: flex; justify-content: center; gap: 15px; flex-wrap: wrap;">
  <img src="https://github.com/user-attachments/assets/082557c2-3c4b-436b-b9eb-51d0db2174e1" 
       style="width: 500px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/47607417-f04a-4f96-a5bb-2d89a3830981" 
       style="width: 500px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/a156407f-812c-4a71-994b-df17cd49e908" 
       style="width: 500px; height: 200px; object-fit: contain;">
  <img src="https://github.com/user-attachments/assets/68c6d6f8-28b2-4be4-a767-68e5f9b47cb9" 
       style="width: 500px; height: 200px; object-fit: contain;">
</div>

These test cases evaluate the system's ability to handle and prevent checkout errors under various invalid conditions. Each scenario verifies proper error messaging and system behavior when checkout requirements are not met:
1.	Empty Cart Checkout (5.1):
o	Ensures the system rejects checkout attempts when the cart is empty, displaying the error: "Cannot checkout with empty cart."
2.	Insufficient Balance (5.2 & 5.4):
o	5.2: Tests a customer with $50.0 balance attempting to purchase a TV costing ~$302.49, triggering an error with precise cost and available balance details.
o	5.4: Validates edge-case handling when the customer’s balance ($25.98) falls just short of the total cost ($26.24), ensuring the system blocks transactions even for minor deficits.
3.	Out-of-Stock Checkout (5.3):
o	Confirms the system prevents checkout if a product (Cheese) is unavailable, first flagging the stock error, then reverting to an empty cart state (implied by the subsequent empty cart error

<div style="display: flex; justify-content: center; gap: 20px; flex-wrap: wrap; margin: 20px 0;">
  <img src="https://github.com/user-attachments/assets/8555d349-5083-4ae9-9bf4-bc6f9f3c42b3" 
       style="width: 400px; height: 300px; object-fit: contain; border: 1px solid #eee; border-radius: 8px;">
  <img src="https://github.com/user-attachments/assets/7de6565c-73ae-41b6-9c68-6e91146f9038" 
       style="width: 600px; height: 300px; object-fit: contain; border: 1px solid #eee; border-radius: 8px;">
</div>

These test cases evaluate the Shipping Service functionality in the e-commerce system, verifying its ability to calculate package weight accurately under different conditions:
1.	Shipping with Multiple Items:
o	Tests the system with a mixed cart containing 2x Cheese (1000g), 3x Biscuits (900g), and 1x TV (5000g).
o	Validates that the shipping service correctly sums the weights, producing a total package weight of 6.9kg.
o	Confirms proper handling of varied product quantities and weights.
2.	Shipping with Empty Cart:
o	Ensures the system gracefully handles an empty cart by displaying a total package weight of 0.0kg.
o	Verifies edge-case behavior, preventing errors or incorrect calculations when no shippable items are present.






