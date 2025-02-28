package util;
import java.util.Scanner;

abstract public class CheckInput {

    public static int handleUserInput() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            // Check if the input is a valid number and within range
            if (checkInput(userInput)) {
                return Integer.parseInt(userInput);
            } else {
                // Clears Console
                System.out.print("\033[H\033[2J");
                System.out.flush();
    
                System.out.println("Invalid input, try again");
                ShowOptions.showOptions(1);
            }
        }
    }

    public static boolean checkInput(String userInput) {
        if (isInteger(userInput)) {
            int value = Integer.parseInt(userInput);
            return value > 0 && value <= 5;
        }
        return false;
    }

    static boolean isInteger(String userInput) {
        return userInput != null && userInput.matches("-?\\d+");
    }
}
