package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;
import util.ApplicationInput;
import util.ApplicationMenu;
import util.Expenses;

public class UpdateExpense {
    static void updateExpense(ArrayList<Expenses> expenseList, Scanner scanner) {

        HandleExpenses.viewExpensesLoop(expenseList);

        System.out.println("\nSelect which expense to update ( type in exact Expense ID ): \n");
        scanner.nextLine();
        String updateExpenseID = scanner.nextLine();
        boolean isExpenseFound = ApplicationInput.handleExpenseUpdate(expenseList, updateExpenseID, scanner);
        if (isExpenseFound) {
            System.out.println("\nExpense was updated!");
        } else {
            System.out.println("\nExpense was not found.");
        }
        ApplicationMenu.clearCommand(scanner);
    }
}
