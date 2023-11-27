package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    @Test
    public void testAddProduct() {
        Cart cart = new Cart();
        Product product = new Product(1, "Test Product", 10.0);

        cart.addProduct(product);
        List<Product> products = cart.getProducts();

        assertEquals(1, products.size());
        assertTrue(products.contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);

        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);
        List<Product> products = cart.getProducts();

        assertEquals(1, products.size());
        assertTrue(products.contains(product2));
    }

    @Test
    public void testGetProducts() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);

        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> products = cart.getProducts();

        assertEquals(2, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }
}