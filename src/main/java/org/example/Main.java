// Main.java
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створюємо список доступних продуктів
        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product(1, "Product 1", 10.0));
        availableProducts.add(new Product(2, "Product 2", 20.0));
        availableProducts.add(new Product(3, "Product 3", 15.0));

        // Створюємо кошик для користувача
        Cart cart = new Cart();

        // Виводимо доступні продукти
        System.out.println("Available Products:");
        for (Product product : availableProducts) {
            System.out.println("Product ID: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice());
        }

        // Додаємо продукти в кошик за допомогою введення користувача
        while (true) {
            System.out.print("Enter product ID to add to the cart (0 to finish): ");
            int productId = scanner.nextInt();
            if (productId == 0) {
                break;
            }

            Product selectedProduct = findProductById(availableProducts, productId);

            if (selectedProduct != null) {
                cart.addProduct(selectedProduct);
                System.out.println("Added to the cart: " + selectedProduct.getName());
            } else {
                System.out.println("Invalid product ID. Please try again.");
            }
        }

        // Виводимо вміст кошика
        System.out.println("Products in the cart:");
        printProductsInCart(cart);

        // Видаляємо продукти з кошика за допомогою введення користувача
        while (true) {
            System.out.print("Enter product ID to remove from the cart (0 to finish): ");
            int productId = scanner.nextInt();
            if (productId == 0) {
                break;
            }

            Product selectedProduct = findProductById(cart.getProducts(), productId);

            if (selectedProduct != null) {
                cart.removeProduct(selectedProduct);
                System.out.println("Removed from the cart: " + selectedProduct.getName());
            } else {
                System.out.println("Product not found in the cart. Please try again.");
            }
        }

        // Виводимо оновлений вміст кошика
        System.out.println("Updated Products in the cart:");
        printProductsInCart(cart);

        // Створюємо замовлення
        Order order = new Order(cart.getProducts());

        // Виводимо інформацію про замовлення та його статус
        System.out.println("\nOrder Details:");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Products in the order:");
        for (Product product : order.getProducts()) {
            System.out.println("Product ID: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice());
        }
        System.out.println("Order Status: " + order.getStatus());

        // Робимо замовлення
        order.placeOrder();

        // Виводимо оновлений статус
        System.out.println("Updated Order Status: " + order.getStatus());

        // Закриваємо Scanner
        scanner.close();
    }

    private static Product findProductById(List<Product> products, int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    private static void printProductsInCart(Cart cart) {
        for (Product product : cart.getProducts()) {
            System.out.println("Product ID: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Price: " + product.getPrice());
        }
    }
}
