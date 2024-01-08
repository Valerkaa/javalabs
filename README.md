# E-Commerce Platform

This Java project simulates an e-commerce platform with various classes to represent users, products, orders, and their interactions.

## Project Structure

1. **ECommerceDemo:**
   The `ECommerceDemo` class serves as the main entry point for the application. It initializes the platform, users, and products, and simulates user interactions.

2. **UserInteractionHandler:**
   The `UserInteractionHandler` class manages user interactions, displaying the main menu and handling user choices.

3. **Order:**
   The `Order` class represents an order, including order items and the calculation of the total price.

4. **User:**
   The `User` class encapsulates user information, such as ID, username, and a shopping cart. It provides methods to add products to the cart and clear it.

5. **Product:**
   The `Product` class defines a product with properties like ID, name, price, and stock. It implements the `Comparable` interface for sorting based on price.

6. **OrderItem:**
   The `OrderItem` class represents an item in an order, consisting of a product and a quantity.

7. **ECommercePlatform:**
   The `ECommercePlatform` class is the core of the e-commerce system. It manages users, products, and orders. It provides methods for adding users and products, creating orders, and displaying information about users, products, and orders.