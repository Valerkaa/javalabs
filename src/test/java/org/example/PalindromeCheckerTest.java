package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @Test
    void isPalindrome_withPalindromeWord_shouldReturnTrue() {
        String palindromeWord = "level";

        boolean result = PalindromeChecker.isPalindrome(palindromeWord);

        assertTrue(result);
    }

    @Test
    void isPalindrome_withNonPalindromeWord_shouldReturnFalse() {
        String nonPalindromeWord = "hello";

        boolean result = PalindromeChecker.isPalindrome(nonPalindromeWord);

        assertFalse(result);
    }

    @Test
    void isPalindrome_withPalindromePhrase_shouldReturnTrue() {
        String palindromePhrase = "A man a plan a canal Panama";

        boolean result = PalindromeChecker.isPalindrome(palindromePhrase);

        assertTrue(result);
    }
}
