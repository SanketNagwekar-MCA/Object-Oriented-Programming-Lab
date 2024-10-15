import java.util.Random;
import java.util.Scanner;

// Entry point of the guessing game application
public class GuessingGameApp {
    public static void main(String[] args) {
        GameSession gameSession = new GameSession();
        gameSession.begin();
    }
}

// Manages the game flow and logic
class GameSession {
    private int targetNumber;
    private final int maxAttempts;
    private int attemptsMade;
    private boolean numberGuessed;
    private User currentUser;
    private final Scanner inputScanner;

    // Constructor to set up the game session
    public GameSession() {
        this.maxAttempts = 10;
        this.attemptsMade = 0;
        this.numberGuessed = false;
        this.inputScanner = new Scanner(System.in);
        this.currentUser = new User();
    }

    // Starts the game session
    public void begin() {
        System.out.println("Welcome to the Number Guessing Challenge!");
        System.out.print("Please enter your name: ");
        currentUser.setUsername(inputScanner.nextLine());

        generateTargetNumber();
        System.out.println("Guess the number between 1 and 100!");

        while (attemptsMade < maxAttempts && !numberGuessed) {
            System.out.print("What is your guess? ");
            int userGuess = inputScanner.nextInt();
            evaluateGuess(userGuess);
        }

        if (numberGuessed) {
            System.out.println("Well done, " + currentUser.getUsername() + "! You found the number in " + attemptsMade + " tries.");
        } else {
            System.out.println("Sorry, " + currentUser.getUsername() + ". You have exhausted all " + maxAttempts + " attempts. The number was " + targetNumber + ".");
        }

        inputScanner.close();
    }

    // Generates a random number to be guessed
    private void generateTargetNumber() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
    }

    // Checks the user's guess and provides feedback
    private void evaluateGuess(int guess) {
        attemptsMade++;
        if (guess == targetNumber) {
            numberGuessed = true;
        } else if (guess < targetNumber) {
            System.out.println("Your guess is too low. Try again!");
        } else {
            System.out.println("Your guess is too high. Try again!");
        }
    }
}

// Stores information about the player
class User {
    private String username;

    // Retrieves the username
    public String getUsername() {
        return username;
    }

    // Sets the username
    public void setUsername(String username) {
        this.username = username;
    }
}
