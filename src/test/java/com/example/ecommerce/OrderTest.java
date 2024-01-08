package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void getOrderItems() {
        List<OrderItem> orderItems = Arrays.asList(
                new OrderItem(new Product(1, "Product1", 10.0, 20), 3),
                new OrderItem(new Product(2, "Product2", 15.0, 30), 2)
        );

        Order order = new Order(1, 123, orderItems);

        assertEquals(orderItems, order.getOrderItems());
    }

    @Test
    void getUserId() {
        Order order = new Order(1, 123, Arrays.asList(
                new OrderItem(new Product(1, "Product1", 10.0, 20), 3)
        ));

        assertEquals(123, order.getUserId());
    }

    @Test
    void getId() {
        Order order = new Order(1, 123, Arrays.asList(
                new OrderItem(new Product(1, "Product1", 10.0, 20), 3)
        ));

        assertEquals(1, order.getId());
    }

    @Test
    void testToString() {
        List<OrderItem> orderItems = Arrays.asList(
                new OrderItem(new Product(1, "Product1", 10.0, 20), 3),
                new OrderItem(new Product(2, "Product2", 15.0, 30), 2)
        );

        Order order = new Order(1, 123, orderItems);

        String expectedToString = "Order{id=1, userId=123, orderItems=" + orderItems + ", totalPrice=" + order.calculateTotalPrice() + '}';
        assertEquals(expectedToString, order.toString());
    }
}
