package util;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class ApplicationInput {

    public static int handleOption(Scanner scanner) {
        while (true) {
            String userInput = scanner.next();

            // Check if the input is a valid number and within range
            if (isValidOption(userInput)) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("\nInvalid input, try again");
                ApplicationMenu.showOptions(false);
            }
        }
    }

    public static boolean handleExpenseDeletion(ArrayList<Expenses> expenseList, String expenseID) {
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getID().equals(expenseID)) {
                expenseList.remove(i);
                Expenses.updateExpenses(expenseList);
                return true;
            };
        }
        return false;
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
