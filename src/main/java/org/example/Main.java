package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String userWord = scanner.nextLine();

        boolean isPalindrome = PalindromeChecker.isPalindrome(userWord);

        System.out.println(userWord + " is a palindrome: " + isPalindrome);

        scanner.close();
    }

    public static class PalindromeChecker {

        public static boolean isPalindrome(String word) {
            String cleanedWord = word.replaceAll("\\s", "").toLowerCase();

            String reversedWord = new StringBuilder(cleanedWord).reverse().toString();

            return cleanedWord.equals(reversedWord);
        }
    }
}
