package com.example.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void getProduct() {
        Product product = new Product(1, "Milk", 10.0, 50);
        OrderItem orderItem = new OrderItem(product, 3);

        assertEquals(product, orderItem.getProduct());
    }

    @Test
    void getQuantity() {
        OrderItem orderItem = new OrderItem(new Product(1, "Milk", 10.0, 50), 3);

        assertEquals(3, orderItem.getQuantity());
    }

    @Test
    void testEquals() {
        Product product1 = new Product(1, "Milk", 10.0, 50);
        Product product2 = new Product(2, "Apple", 15.0, 30);

        OrderItem orderItem1 = new OrderItem(product1, 3);
        OrderItem orderItem2 = new OrderItem(product1, 3);
        OrderItem orderItem3 = new OrderItem(product2, 5);

        assertEquals(orderItem1, orderItem2);
        assertNotEquals(orderItem1, orderItem3);
    }

    @Test
    void testHashCode() {
        Product product1 = new Product(1, "Milk", 10.0, 50);
        Product product2 = new Product(2, "Apple", 15.0, 30);

        OrderItem orderItem1 = new OrderItem(product1, 3);
        OrderItem orderItem2 = new OrderItem(product1, 3);
        OrderItem orderItem3 = new OrderItem(product2, 5);

        assertEquals(orderItem1.hashCode(), orderItem2.hashCode());
        assertNotEquals(orderItem1.hashCode(), orderItem3.hashCode());
    }

    @Test
    void testToString() {
        Product product = new Product(1, "Milk", 10.0, 50);
        OrderItem orderItem = new OrderItem(product, 3);

        String expectedToString = "OrderItem{product=Product{id=1, name='Milk', price=10.0, stock=50}, quantity=3}";

        assertEquals(expectedToString, orderItem.toString());
    }
}
