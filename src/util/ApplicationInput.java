package util;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class ApplicationInput {

    public static int handleOption(Scanner scanner, int range, boolean applicationMenu) {
        while (true) {
            String userInput = scanner.next();

            // Check if the input is a valid number and within range
            if (isValidOption(userInput, range)) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("\nInvalid input, try again\n");
                if (applicationMenu) ApplicationMenu.showOptions(false);
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

    public static boolean handleExpenseUpdate(ArrayList<Expenses> expenseList, String expenseID, Scanner scanner) {
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getID().equals(expenseID)) {

                float expenseAmount;
                String expenseDescription;
                String expenseCategory;

                ApplicationMenu.clearConsole();
                System.out.println("Expense found, how much money for this expense?\n");
                while (true) {
                    String inputExpenseAmount = scanner.next();
        
                    if (ApplicationInput.isFloat(inputExpenseAmount)) {
                        expenseAmount = Float.parseFloat(inputExpenseAmount);
                        break;
                    } else {
                        System.out.println("\nInvalid input, try again: \n");
                    }
                }

                System.out.println("\nWhat would you like to write in the expense description? \n");

                scanner.nextLine();
                expenseDescription = scanner.nextLine();

                System.out.println("\nWhat category is the expense? \n");

                expenseCategory = scanner.nextLine();

                expenseList.get(i).setExpense(expenseDescription, expenseCategory, expenseAmount);
                Expenses.updateExpenses(expenseList);
                return true;
            }
        }
        return false;
    }

    static boolean isValidOption(String userInput, int range) {
        if (isInteger(userInput)) {
            int value = Integer.parseInt(userInput);
            return value > 0 && value <= range;
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
