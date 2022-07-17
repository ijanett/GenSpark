import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean playing = true;
        Boolean won = false;
        int count = 0;

        System.out.println("Hello! What is your name?");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();
        System.out.println(String.format("Well, %s, I am thinking of a number between 1 and 20.", userName));
        String playAgain = "Would you like to play again? (y or n)";

        do {
            int guess = (int) (Math.random() * 20) + 1;
            String input;
            int inputInt;

            do {
                System.out.println("Take a guess.");
                input = userInput.nextLine();
                inputInt = Integer.parseInt(input);

                if (inputInt < guess) {
                    count++;
                    System.out.println("Your guess is too low.");
                } else if (inputInt > guess) {
                    count++;
                    System.out.println("Your guess is too high.");
                } else {
                    count++;
                    won = true;
                    System.out.println(String.format("Good job, %s! You guessed my number in %d guesses!", userName, count));
                }
            } while (inputInt != guess && count < 6);
            playing = false;

            if (count >= 6 && !won) {
                System.out.println("Too many guesses. Better luck next time!");
            }
            System.out.println(playAgain);
            String playInput = userInput.nextLine();

            if (playInput.equals("y")) {
                playing = true;
                count = 0;
            }
        } while (playing);
    }
}