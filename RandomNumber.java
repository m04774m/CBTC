import java.util.Random;
import java.util.Scanner;
 class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + (attempts + 1) + " attempts.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Try again! The number is higher.");
            } else {
                System.out.println("Try again! The number is lower.");
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}