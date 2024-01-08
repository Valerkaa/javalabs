package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        User user = new User(1, "testUser");
        assertEquals(1, user.getId());
    }

    @Test
    void getCart() {
        User user = new User(1, "testUser");
        assertNotNull(user.getCart());
        assertTrue(user.getCart().isEmpty());
    }

    @Test
    void addToCart() {
        User user = new User(1, "testUser");
        Product product = new Product(1, "TestProduct", 10.0, 50);
        user.addToCart(product, 3);

        assertTrue(user.getCart().containsKey(product));
        assertEquals(3, user.getCart().get(product));
    }

    @Test
    void clearCart() {
        User user = new User(1, "testUser");
        Product product = new Product(1, "TestProduct", 10.0, 50);
        user.addToCart(product, 3);

        assertFalse(user.getCart().isEmpty());

        user.clearCart();

        assertTrue(user.getCart().isEmpty());
    }

    @Test
    void testToString() {
        User user = new User(1, "testUser");
        Product product = new Product(1, "TestProduct", 10.0, 50);
        user.addToCart(product, 3);

        String expectedToString = "User{id=1, username='testUser', cart={TestProduct=3}}";
        assertEquals(expectedToString, user.toString());
    }
}
