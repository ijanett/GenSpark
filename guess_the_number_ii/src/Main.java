import org.w3c.dom.ranges.RangeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static boolean isInputValid(String input) {
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n");
    }

    public static void validateInput(String input) {
        if (!isInputValid(input)) {
            throw new IllegalArgumentException("Invalid option. Exiting game...");
        } else if (input.toLowerCase().equals("n")) {
            System.out.println("Exiting game...");
        }
    }
    private static boolean isGuessValid(int input) {
        return 1 <= input && input <= 20;
    }
    public static void validateGuess(int input) {
        if (!isGuessValid(input)) {
            throw new IllegalArgumentException("Number out of range.");
        }
    }
    public static void main(String[] args) {
        boolean playing = true;
        boolean won = false;
        int count = 0;

        System.out.println("Hello! What is your name?");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20.%n", userName);
        String playAgain = "Would you like to play again? (y or n)";

        do {
            int random = (int) (Math.random() * 20) + 1;
            int guess = 0;

            do {
                System.out.println("Take a guess.");

                try {
                    guess = userInput.nextInt();
                    validateGuess(guess);
                } catch (InputMismatchException e) {
                    throw new RuntimeException("Input not a valid integer.");
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e.getMessage());
                }

                if (guess < random) {
                    count++;
                    System.out.println("Your guess is too low.");
                } else if (guess > random) {
                    count++;
                    System.out.println("Your guess is too high.");
                } else {
                    count++;
                    won = true;
                    System.out.printf("Good job, %s! You guessed my number in %d guess(es)!%n", userName, count);
                }
            } while (guess != random && count < 6);
            playing = false;

            if (count >= 6 && !won) {
                System.out.println("Too many guesses. Better luck next time!");
            }
            System.out.println(playAgain);
            userInput.nextLine();
            String playInput = userInput.nextLine();

            try {
                validateInput(playInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (playInput.equalsIgnoreCase("y")) {
                playing = true;
                count = 0;
            }


        } while (playing);
    }
}