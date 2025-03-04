package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;

import util.ApplicationInput;
import util.ApplicationMenu;
import util.Expenses;

public class AddExpense {
    static void addExpense(ArrayList<Expenses> expenseList, Scanner scanner) {

        float expenseAmount;
        String expenseDescription;
        String expenseCategory;

        ApplicationMenu.clearConsole();

        System.out.println("How much money are you spending on this expense? ( In $ )\n");
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

        Expenses expense = new Expenses(expenseDescription, expenseAmount, expenseCategory);
        expenseList.add(expense);
        Expenses.saveExpense(expense);

        ApplicationMenu.clearConsole();
        System.out.println("Expense added to list!");
        ApplicationMenu.showOptions(false);
    }
}
