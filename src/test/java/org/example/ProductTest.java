package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void getId() {
        // Arrange
        int expectedId = 1;
        Product product = new Product(expectedId, "Test Product", 15.0);

        // Act
        int actualId = product.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

    @Test
    void getName() {
        // Arrange
        String expectedName = "Test Product";
        Product product = new Product(1, expectedName, 15.0);

        // Act
        String actualName = product.getName();

        // Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    void getPrice() {
        // Arrange
        double expectedPrice = 15.0;
        Product product = new Product(1, "Test Product", expectedPrice);

        // Act
        double actualPrice = product.getPrice();

        // Assert
        assertEquals(expectedPrice, actualPrice);
    }
}
