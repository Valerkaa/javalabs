package com.example.ecommerce;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        UserInteractionHandler userInteractionHandler = new UserInteractionHandler(ecommercePlatform);

        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        User user3 = new User(3, "user3");
        User user4 = new User(4, "user4");
        User user5 = new User(5, "user5");
        ecommercePlatform.addUser(user1);
        ecommercePlatform.addUser(user2);
        ecommercePlatform.addUser(user3);
        ecommercePlatform.addUser(user4);
        ecommercePlatform.addUser(user5);

        Product product1 = new Product(1, "Milk", 10.0, 50);
        Product product2 = new Product(2, "Apple", 15.0, 30);
        Product product3 = new Product(3, "Bread", 5.0, 40);
        Product product4 = new Product(4, "Banana", 2.5, 100);
        Product product5 = new Product(5, "Coffee", 8.0, 20);
        ecommercePlatform.addProduct(product1);
        ecommercePlatform.addProduct(product2);
        ecommercePlatform.addProduct(product3);
        ecommercePlatform.addProduct(product4);
        ecommercePlatform.addProduct(product5);

        userInteractionHandler.simulateInteractions();

        System.out.println("ECommerce Platform state after interactions:");
        System.out.println(ecommercePlatform);
    }
}

class UserInteractionHandler {
    private final ECommercePlatform ecommercePlatform;
    private final Scanner scanner;

    public UserInteractionHandler(ECommercePlatform ecommercePlatform) {
        this.ecommercePlatform = ecommercePlatform;
        this.scanner = new Scanner(System.in);
    }

    public void simulateInteractions() {
        // Simulate interactions here
        // For example:
        // - Display available products
        // - Add products to the cart
        // - Create orders
        // - Display users, orders, etc.

        displayMainMenu();
    }

    private void displayMainMenu() {
        while (true) {
            System.out.println("===== Main Menu =====");
            System.out.println("1. Display available products");
            System.out.println("2. Add products to the cart");
            System.out.println("3. Create an order");
            System.out.println("4. Display users");
            System.out.println("5. Display orders");
            System.out.println("6. Exit");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    displayAvailableProductsMenu();
                    break;
                case 2:
                    addToCartMenu();
                    break;
                case 3:
                    createOrderMenu();
                    break;
                case 4:
                    System.out.println("Users: " + ecommercePlatform.displayUsers());
                    break;
                case 5:
                    System.out.println("Orders: " + ecommercePlatform.displayOrders());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void displayAvailableProductsMenu() {
        System.out.println("===== Available Products =====");
        System.out.println("1. Display all products");
        System.out.println("2. Display products sorted by name");
        System.out.println("3. Display products sorted by price");
        System.out.println("4. Display products sorted by stock");
        System.out.println("5. Display products with available stock");
        System.out.println("6. Back to main menu");

        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1:
                System.out.println("Available Products:");
                displayProductsNewLine(ecommercePlatform.getAllProducts());
                break;
            case 2:
                displaySortedProducts(new ProductNameComparator());
                break;
            case 3:
                displaySortedProducts(new ProductPriceComparator());
                break;
            case 4:
                displaySortedProducts(new ProductStockComparator());
                break;
            case 5:
                System.out.println("Available Products: " + ecommercePlatform.displayAvailableProducts());
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private void displayProductsNewLine(Map<Integer, Product> products) {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Stock: " + product.getStock());
            System.out.println("----------------------");
        }
    }

    private void addToCartMenu() {
        System.out.println("===== Add Products to Cart =====");
        int userId = getIntInput("Enter user ID: ");
        User user = ecommercePlatform.getUser(userId);

        if (user != null) {
            System.out.println("Available Products:");
            displayProductsNewLine(ecommercePlatform.getAllProducts());

            int productId = getIntInput("Enter product ID to add to the cart: ");
            Product product = ecommercePlatform.getProduct(productId);

            if (product != null) {
                int quantity = getIntInput("Enter quantity: ");
                user.addToCart(product, quantity);
                System.out.println("Product added to the cart successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    private void createOrderMenu() {
        System.out.println("===== Create Order =====");
        int userId = getIntInput("Enter user ID: ");
        User user = ecommercePlatform.getUser(userId);

        if (user != null && !user.getCart().isEmpty()) {
            Order order = ecommercePlatform.createOrder(user.getId());
            if (order != null) {
                System.out.println("Order created: " + order);
            } else {
                System.out.println("Failed to create order. Cart is empty.");
            }
        } else {
            System.out.println("User not found or cart is empty.");
        }
    }

    private void displaySortedProducts(Comparator<Product> comparator) {
        List<Product> productsList = new ArrayList<>(ecommercePlatform.getAllProducts().values());
        productsList.sort(comparator);

        System.out.println("===== Sorted Products =====");
        for (Product product : productsList) {
            System.out.println(product);
        }
        System.out.println("===========================");
    }

    private void displayFilteredProducts(int minStock) {
        List<Product> filteredProducts = ecommercePlatform.getAllProducts().values().stream()
                .filter(product -> product.getStock() >= minStock)
                .collect(Collectors.toList());

        System.out.println("===== Filtered Products =====");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
        System.out.println("=============================");
    }


    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    private void displayProducts(Map<Integer, Product> products) {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Stock: " + product.getStock());
            System.out.println("----------------------");
        }
    }
}

class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class ProductStockComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p1.getStock(), p2.getStock());
    }
}
