package org.example;

public class Booking {
    public static void bookSeats(char[][][] hall, int row, int[] seats, int hallNumber) {
        for (int seat : seats) {
            if (seat >= 0 && seat < hall[hallNumber][row].length) {
                hall[hallNumber][row][seat] = '1';
            } else {
                System.out.println("Error: Seat number " + (seat + 1) + " is outside the boundaries of the hall.");
            }
        }
    }

    public static void cancelBooking(char[][][] hall, int row, int[] seats, int hallNumber) {
        for (int seat : seats) {
            if (seat >= 0 && seat < hall[hallNumber][row].length) {
                hall[hallNumber][row][seat] = 'O';
            } else {
                System.out.println("Error: Seat number " + (seat + 1) + " is outside the boundaries of the hall.");
            }
        }
    }

    public static boolean checkAvailability(char[][][] hall, int row, int numSeats, int hallNumber) {
        if (hallNumber < 0 || hallNumber >= hall.length || row < 0 || row >= hall[hallNumber].length) {
            System.out.println("Invalid row or hall number indices.");
            return false;
        }

        int count = 0;
        for (int i = 0; i < hall[hallNumber][row].length; i++) {
            if (hall[hallNumber][row][i] == 'O') {
                count++;
                if (count == numSeats) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}