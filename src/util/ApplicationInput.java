package util;
import java.util.Scanner;

abstract public class ApplicationInput {

    public static int handleOption() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            // Check if the input is a valid number and within range
            if (isValidOption(userInput)) {
                scanner.close();
                return Integer.parseInt(userInput);
            } else {
                scanner.close();
                // Clears Console
                System.out.print("\033[H\033[2J");
                System.out.flush();
    
                System.out.println("Invalid input, try again");
                ApplicationMenu.showOptions(false);
            }
        }
    }

    static boolean isValidOption(String userInput) {
        if (isInteger(userInput)) {
            int value = Integer.parseInt(userInput);
            return value > 0 && value <= 5;
        }
        return false;
    }

    // These methods check if integers/floats are valid and are POSITIVE values
    // ( negative are not accepted )

    public static boolean isInteger(String userInput) {
        return userInput != null && userInput.matches("^\\d+$");
    }

    public static boolean isFloat(String userInput) {
        return userInput != null && userInput.matches("^\\d+(\\.\\d{1,2})?$");
    }
}
