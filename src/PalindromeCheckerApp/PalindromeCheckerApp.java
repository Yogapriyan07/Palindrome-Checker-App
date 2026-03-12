import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        // Compare with original string
        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.isPalindrome(text);
    }
}

// Main Application
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checker.setStrategy(new StackStrategy());
                break;
            case 2:
                checker.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}


































































