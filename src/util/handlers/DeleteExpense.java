package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;
import util.ApplicationInput;
import util.ApplicationMenu;
import util.Expenses;

public class DeleteExpense {
    static void deleteExpense(ArrayList<Expenses> expenseList, Scanner scanner) {

        HandleExpenses.viewExpensesLoop(expenseList);

        System.out.println("\nSelect which expense to delete ( type in exact Expense ID ): \n");
        scanner.nextLine();
        String deleteExpenseID = scanner.nextLine();
        boolean isExpenseFound = ApplicationInput.handleExpenseDeletion(expenseList, deleteExpenseID);
        if (isExpenseFound) {
            System.out.println("\nExpense was found and deleted!");
        } else {
            System.out.println("\nExpense was not found.");
        }
        ApplicationMenu.clearCommand(scanner);
    }
}
