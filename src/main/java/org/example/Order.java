// Order.java
package org.example;

import java.util.List;

public class Order {
    private static int orderIdCounter = 1;
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(List<Product> products) {
        this.orderId = orderIdCounter++;
        this.products = products;
        this.status = "Processing";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void placeOrder() {
        if (status.equals("Processing")) {
            // Можна реалізувати логіку розміщення замовлення, наприклад, відправка підтвердження
            System.out.println("Order placed successfully!");
            status = "Placed";
        } else {
            System.out.println("Order has already been placed.");
        }
    }
}
