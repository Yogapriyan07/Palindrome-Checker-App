import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Using reverse string
    public static boolean checkPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Method 2: Using two-pointer technique
    public static boolean checkPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 3: Using Stack
    public static boolean checkPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Algorithm 1 timing
        long start1 = System.nanoTime();
        boolean result1 = checkPalindromeReverse(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Algorithm 2 timing
        long start2 = System.nanoTime();
        boolean result2 = checkPalindromeTwoPointer(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Algorithm 3 timing
        long start3 = System.nanoTime();
        boolean result3 = checkPalindromeStack(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("\n=== Results ===");

        System.out.println("Reverse String Method:");
        System.out.println("Palindrome: " + result1);
        System.out.println("Execution Time: " + time1 + " ns");

        System.out.println("\nTwo Pointer Method:");
        System.out.println("Palindrome: " + result2);
        System.out.println("Execution Time: " + time2 + " ns");

        System.out.println("\nStack Method:");
        System.out.println("Palindrome: " + result3);
        System.out.println("Execution Time: " + time3 + " ns");

        scanner.close();
    }
}


































































