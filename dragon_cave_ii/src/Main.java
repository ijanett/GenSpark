import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

import static java.lang.reflect.Array.*;
import static java.util.Arrays.asList;

public class Main {
    public static void validateInput(String input) {
        if (!isInputValid(input)) {
            throw new IllegalArgumentException("Invalid input. Exiting game...\"");
        }
    }
    private static boolean isInputValid(String input) {
        List<String> validInputs = asList("1", "2");
        if (validInputs.contains(input)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String outMsg = "You are in a land full of dragons. In front of you,\n" +
            "you see two caves. In one cave, the dragon is friendly\n" +
            "and will share his treasure with you. The other dragon\n" +
            "is greedy and hungry and will eat you on sight.\n" +
            "Which cave will you go into? (1 or 2)";

        System.out.println(outMsg);
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        try {
            validateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            if (input.equals("1")) {
                System.out.println("You approach the cave...\n" +
                        "It's dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down in one bite!");
            } else if (input.equals("2")) {
                System.out.println("Great choice! You're still alive and a bit richer!");
            }
        }
    }
}