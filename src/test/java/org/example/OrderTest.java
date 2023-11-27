package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getOrderId() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Order order = new Order(products);

        // Act
        int orderId = order.getOrderId();

        // Assert
        assertTrue(orderId > 0);
    }

    @Test
    void getProducts() {
        // Arrange
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 10.0));
        products.add(new Product(2, "Product 2", 20.0));
        Order order = new Order(products);

        // Act
        List<Product> retrievedProducts = order.getProducts();

        // Assert
        assertEquals(products, retrievedProducts);
    }

    @Test
    void getStatus() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Order order = new Order(products);

        // Act
        String status = order.getStatus();

        // Assert
        assertEquals("Processing", status);
    }

    @Test
    void setStatus() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Order order = new Order(products);

        // Act
        order.setStatus("Shipped");

        // Assert
        assertEquals("Shipped", order.getStatus());
    }

    @Test
    void placeOrder() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Order order = new Order(products);

        // Act
        order.placeOrder();

        // Assert
        assertEquals("Placed", order.getStatus());
    }
}
