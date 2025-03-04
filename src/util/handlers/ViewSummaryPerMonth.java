package util.handlers;

import java.util.ArrayList;
import java.util.Scanner;
import util.ApplicationInput;
import util.ApplicationMenu;
import util.Expenses;

public class ViewSummaryPerMonth {
    static void viewSummaryPerMonth(ArrayList<Expenses> expenseList, Scanner scanner) {
        ApplicationMenu.clearConsole();
        System.out.println("Which month do you want to view? ( type a number from 1 - 12)\n");
        int userChoice = ApplicationInput.handleOption(scanner, 12, false);
        float expenseSummary = 0;
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getMonth() == userChoice) {
                expenseSummary += expenseList.get(i).getAmount();
            }
        }

        System.out.println("\nTotal expenses for the month you specified is: " + expenseSummary + "$");
        ApplicationMenu.clearCommand(scanner, true);
    }
}
