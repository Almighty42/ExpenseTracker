package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;

import util.ApplicationMenu;
import util.Expenses;

public class ViewSummary {
    static void viewSummary(ArrayList<Expenses> expenseList, Scanner scanner) {
        ApplicationMenu.clearConsole();
        float totalExpenses = 0;
        for (int i = 0; i < expenseList.size(); i++) {
            totalExpenses += expenseList.get(i).getAmount();
        }
        System.out.println("Total expenses: " + totalExpenses + "$");
        ApplicationMenu.clearCommand(scanner, true);
    }
}
