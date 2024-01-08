package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ECommercePlatformTest {

    @Test
    void addUser() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);
        assertEquals(user, ecommercePlatform.getUser(1));
    }

    @Test
    void addProduct() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        Product product = new Product(1, "TestProduct", 10.0, 20);
        ecommercePlatform.addProduct(product);
        assertEquals(product, ecommercePlatform.getProduct(1));
    }

    @Test
    void createOrder() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);

        Product product = new Product(1, "TestProduct", 10.0, 20);
        ecommercePlatform.addProduct(product);

        user.addToCart(product, 5);
        Order order = ecommercePlatform.createOrder(user.getId());

        assertNotNull(order);
        assertEquals(user.getId(), order.getUserId());
        assertEquals(1, order.getOrderItems().size());
        assertEquals(product, order.getOrderItems().get(0).getProduct());
        assertEquals(5, order.getOrderItems().get(0).getQuantity());
    }

    @Test
    void getUser() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);
        assertEquals(user, ecommercePlatform.getUser(1));
    }

    @Test
    void getProduct() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        Product product = new Product(1, "TestProduct", 10.0, 20);
        ecommercePlatform.addProduct(product);
        assertEquals(product, ecommercePlatform.getProduct(1));
    }

    @Test
    void getOrder() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);

        Product product = new Product(1, "TestProduct", 10.0, 20);
        ecommercePlatform.addProduct(product);

        user.addToCart(product, 5);
        Order order = ecommercePlatform.createOrder(user.getId());

        assertNotNull(order);
        assertEquals(order, ecommercePlatform.getOrder(order.getId()));
    }

    @Test
    void displayAvailableProducts() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        Product product1 = new Product(1, "Product1", 10.0, 50);
        Product product2 = new Product(2, "Product2", 15.0, 30);
        ecommercePlatform.addProduct(product1);
        ecommercePlatform.addProduct(product2);

        String expected = "Product ID: 1\nName: Product1\nPrice: $10.0\nStock: 50\n----------------------\n" +
                "Product ID: 2\nName: Product2\nPrice: $15.0\nStock: 30\n----------------------\n";

        assertEquals(expected, ecommercePlatform.displayAvailableProducts());
    }

    @Test
    void displayUsers() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);

        String expected = "===== Users =====\nUser{id=1, username='TestUser', cart={}}\n=================\n";
        assertEquals(expected, ecommercePlatform.displayUsers());
    }

    @Test
    void displayOrders() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "TestUser");
        ecommercePlatform.addUser(user);

        Product product = new Product(1, "TestProduct", 10.0, 20);
        ecommercePlatform.addProduct(product);

        user.addToCart(product, 5);
        Order order = ecommercePlatform.createOrder(user.getId());

        String expected = "===== Orders =====\n" +
                "Order{id=1, userId=1, orderItems=[OrderItem{product=Product{id=1, name='TestProduct', price=10.0, stock=15}, quantity=5}], totalPrice=50.0}\n" +
                "=================";

        assertEqualIgnoringNewline(expected, ecommercePlatform.displayOrders());
    }

    private void assertEqualIgnoringNewline(String expected, String actual) {
        String[] expectedLines = expected.split("\\r?\\n");
        String[] actualLines = actual.split("\\r?\\n");
        assertEquals(expectedLines.length, actualLines.length);

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i].trim(), actualLines[i].trim());
        }
    }

    @Test
    void testToString() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        assertEquals("ECommercePlatform{users={}, products={}, orders={}}", ecommercePlatform.toString());
    }

    @Test
    void getAllProducts() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        Product product1 = new Product(1, "Product1", 10.0, 50);
        Product product2 = new Product(2, "Product2", 15.0, 30);
        ecommercePlatform.addProduct(product1);
        ecommercePlatform.addProduct(product2);

        Map<Integer, Product> allProducts = ecommercePlatform.getAllProducts();

        assertTrue(allProducts.containsKey(1));
        assertTrue(allProducts.containsKey(2));
        assertEquals(product1, allProducts.get(1));
        assertEquals(product2, allProducts.get(2));
    }

    @Test
    void displayProducts() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        Product product1 = new Product(1, "Product1", 10.0, 50);
        Product product2 = new Product(2, "Product2", 15.0, 30);
        ecommercePlatform.addProduct(product1);
        ecommercePlatform.addProduct(product2);

        String expected = "Product ID: 1\nName: Product1\nPrice: $10.0\nStock: 50\n----------------------\n" +
                "Product ID: 2\nName: Product2\nPrice: $15.0\nStock: 30\n----------------------\n";

        assertEquals(expected, ecommercePlatform.displayProducts(ecommercePlatform.getAllProducts()));
    }
}
