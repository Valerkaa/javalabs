package org.example;

public class PalindromeChecker {

    public static boolean isPalindrome(String word) {
        String cleanedWord = word.replaceAll("\\s", "").toLowerCase();

        String reversedWord = new StringBuilder(cleanedWord).reverse().toString();

        return cleanedWord.equals(reversedWord);
    }
}
