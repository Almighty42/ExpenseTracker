package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;

import util.ApplicationMenu;
import util.Expenses;

public class ViewExpenses {
    static void viewExpenses(ArrayList<Expenses> expenseList, Scanner scanner) {
        HandleExpenses.viewExpensesLoop(expenseList);
        ApplicationMenu.clearCommand(scanner, true);
    }
}
