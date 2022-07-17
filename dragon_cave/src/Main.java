import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String outMsg = "You are in a land full of dragons. In front of you,\nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.\nWhich cave will you go into? (1 or 2)";
        System.out.println(outMsg);
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        String result;
        switch (input) {
            case "1":
                result = "You approach the cave...\nIt's dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nGobbles you down in one bite!";
                break;
            case "2":
                result = "Great choice! You're still alive and a bit richer!";
                break;
            default:
                result = "Invalid option. Exiting game...";
        };
        System.out.println(result);
    }
}