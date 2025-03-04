package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;
import util.ApplicationMenu;
import util.Expenses;

public class HandleExpenses {

    public static void handleExpenses(int userChoice, ArrayList<Expenses> expenseList, Scanner scanner) {
        if (userChoice == 1) AddExpense.addExpense(expenseList, scanner);
        if (userChoice == 2) DeleteExpense.deleteExpense(expenseList, scanner);
        if (userChoice == 3) UpdateExpense.updateExpense(expenseList, scanner);
        if (userChoice == 4) ViewExpenses.viewExpenses(expenseList, scanner);
        if (userChoice == 5) ViewSummary.viewSummary(expenseList, scanner);
        if (userChoice == 6) ViewSummaryPerMonth.viewSummaryPerMonth(expenseList, scanner);
        if (userChoice == 7) System.exit(0);
    }

    public static void viewExpensesLoop(ArrayList<Expenses> expenseList) {
        ApplicationMenu.clearConsole();

        System.out.println("# ID\t\tDate\t\tDescription\t\tAmount");
        for (int i = 0; i < expenseList.size(); i++) {
            Expenses expense = expenseList.get(i);
            System.out.println("# " + expense.getExpense());
        }
    }

}