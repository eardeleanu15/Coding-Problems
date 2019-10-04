package edu.algorithms.strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString {

    public static void main(String[] args) {
        String palindrome = "A man, a plan, a canal: Panama";
        System.out.println("Is \"A man, a plan, a canal: Panama\" palindrome? " +
            (isPalindrome(palindrome) == 1 ? "Yes" : "No"));
    }

    public static int isPalindrome(String A) {

        if (A == null || A.isEmpty()) {
            return 0;
        }

        String lowerCaseA = A.toLowerCase();
        StringBuilder sb = new StringBuilder("");

        for (Character c : lowerCaseA.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }

        String sanitizedString = sb.toString();
        String reverseString = sb.reverse().toString();

        for (int i = 0; i < sanitizedString.length(); i++) {
            if (sanitizedString.charAt(i) != reverseString.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }

}
