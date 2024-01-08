package com.example.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product = new Product(1, "Milk", 10.0, 50);
        assertEquals(1, product.getId());
    }

    @Test
    void setStock() {
        Product product = new Product(1, "Milk", 10.0, 50);
        product.setStock(30);
        assertEquals(30, product.getStock());
    }

    @Test
    void getName() {
        Product product = new Product(1, "Milk", 10.0, 50);
        assertEquals("Milk", product.getName());
    }

    @Test
    void getPrice() {
        Product product = new Product(1, "Milk", 10.0, 50);
        assertEquals(10.0, product.getPrice(), 0.01);
    }

    @Test
    void getStock() {
        Product product = new Product(1, "Milk", 10.0, 50);
        assertEquals(50, product.getStock());
    }

    @Test
    void testToString() {
        Product product = new Product(1, "Milk", 10.0, 50);
        String expectedToString = "Product{id=1, name='Milk', price=10.0, stock=50}";
        assertEquals(expectedToString, product.toString());
    }

    @Test
    void compareTo() {
        Product product1 = new Product(1, "Milk", 10.0, 50);
        Product product2 = new Product(2, "Apple", 15.0, 30);
        Product product3 = new Product(3, "Bread", 5.0, 40);

        assertTrue(product1.compareTo(product2) < 0);
        assertTrue(product2.compareTo(product3) > 0);
        assertEquals(0, product1.compareTo(product1));
    }
}
