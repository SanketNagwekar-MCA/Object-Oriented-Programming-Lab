import java.util.function.Consumer;

// Generic class to hold a pair of values
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    // Generic method to print the pair
    public void printPair() {
        System.out.println("First: " + first + ", Second: " + second);
    }
}

// Exception handling class
class Division {
    public static double divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) numerator / denominator;
    }
}

public class Main {
    public static void main(String[] args) {
        // Exception handling
        try {
            System.out.println("Division Result: " + Division.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Using generics
        Pair<Integer, String> pair = new Pair<>(1, "One");
        pair.printPair();

        // Lambda function
        Consumer<String> printUpperCase = (str) -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello world");
    }
}
