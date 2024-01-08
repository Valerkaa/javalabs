package org.example;

import java.util.Scanner;

public class Main {
    private static char[][][] hall;
    private static int numRows = 10;
    private static int numSeats = 20;

    public static void main(String[] args) {
        int numHalls = 5;

        hall = Initialization.initializeHall(numRows, numSeats, numHalls);

        Scanner scanner = new Scanner(System.in);

        int selectedHall = selectHall(scanner, numHalls);
        printSeatingArrangement(selectedHall);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Switch Hall");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel reservation");
            System.out.println("4. Check seat availability");
            System.out.println("5. Print seating arrangement");
            System.out.println("0. Exit");

            int choice;

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please try again: ");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectedHall = switchHall(scanner, numHalls);
                    break;
                case 2:
                    bookSeats(scanner, selectedHall);
                    break;
                case 3:
                    cancelBooking(scanner, selectedHall);
                    break;
                case 4:
                    checkAvailability(scanner, selectedHall);
                    break;
                case 5:
                    printSeatingArrangement(selectedHall);
                    break;
                case 0:
                    System.out.println("Thank you for using the reservation system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int switchHall(Scanner scanner, int numHalls) {
        int selectedHall = selectHall(scanner, numHalls);
        printSeatingArrangement(selectedHall);
        return selectedHall;
    }

    private static int selectHall(Scanner scanner, int numHalls) {
        System.out.println("Select the hall number (1-" + numHalls + "): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the hall number again: ");
            scanner.next();
        }

        int selectedHall = scanner.nextInt();

        while (selectedHall < 1 || selectedHall > numHalls) {
            System.out.println("Invalid hall number. Please try again: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the hall number again: ");
                scanner.next();
            }

            selectedHall = scanner.nextInt();
        }

        return selectedHall - 1;
    }

    private static void bookSeats(Scanner scanner, int selectedHall) {
        System.out.println("Enter the row and seat numbers to reserve:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the row again: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the number of seats again: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        if (Booking.checkAvailability(hall, row, numSeats, selectedHall)) {
            int[] seats = new int[numSeats];
            System.out.println("Enter seat numbers (from 1 to " + numSeats + "):");

            for (int i = 0; i < numSeats; i++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Enter the seat number again: ");
                    scanner.next();
                }

                seats[i] = scanner.nextInt() - 1;
            }

            Booking.bookSeats(hall, row, seats, selectedHall);
            System.out.println("Seats reserved successfully.");

            System.out.println("After reservation:");
            printSeatingArrangement(selectedHall);
        } else {
            System.out.println("Not enough seats for reservation.");
        }
    }

    private static void cancelBooking(Scanner scanner, int selectedHall) {
        System.out.println("Enter the row and seat numbers to cancel the reservation:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the row again: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the number of seats again: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        int[] seats = new int[numSeats];
        System.out.println("Enter seat numbers:");

        for (int i = 0; i < numSeats; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter the seat number again: ");
                scanner.next();
            }

            seats[i] = scanner.nextInt() - 1;
        }

        Booking.cancelBooking(hall, row, seats, selectedHall);
        System.out.println("Booking canceled successfully.");

        System.out.println("After cancellation:");
        printSeatingArrangement(selectedHall);
    }

    private static void checkAvailability(Scanner scanner, int selectedHall) {
        System.out.println("Enter the row and number of seats:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the row again: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter the number of seats again: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        boolean availability = Booking.checkAvailability(hall, row, numSeats, selectedHall);

        if (availability) {
            System.out.println("Availability of " + numSeats + " seats in row " + (row + 1) + ": Yes, there are available seats.");
        } else {
            System.out.println("Availability of " + numSeats + " seats in row " + (row + 1) + ": No, all seats are reserved.");
        }
    }

    private static void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating arrangement for Hall " + (hallNumber + 1) + ":");
        System.out.print("    ");

        for (int i = 1; i <= numSeats; i++) {
            if (i < 10) {
                System.out.print("   " + i);
            } else {
                System.out.print("  " + i);
            }
        }

        System.out.println();

        for (int i = 0; i < numRows; i++) {
            System.out.print((i + 1) + "  |");

            for (int j = 0; j < numSeats; j++) {
                System.out.print("   " + getSeatStatus(hall[hallNumber][i][j]));
            }

            System.out.println();
        }
    }

    private static String getSeatStatus(char seat) {
        return seat == 'O' ? "O" : "X";
    }
}