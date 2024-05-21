import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            int attempts = playGame(scanner);
            totalScore += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over! You've played " + roundsPlayed + " rounds with a total score of " + totalScore + " attempts.");
        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            try {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }

                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number " + numberToGuess + " in " + attempts + " attempts.");
                    return attempts;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
        return maxAttempts;
    }
}