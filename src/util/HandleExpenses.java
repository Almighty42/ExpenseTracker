package util;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleExpenses {

    public static void handleExpenses(int userChoice, ArrayList<Expenses> expenseList) {
        if (userChoice == 1) addExpense(expenseList);
        if (userChoice == 2) deleteExpense();
        if (userChoice == 3) viewExpenses();
        if (userChoice == 4) viewSummary();
        if (userChoice == 5) viewSummaryPerMonth();
    }

    static void addExpense(ArrayList<Expenses> expenseList) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("How much money are you spending on this expense? ( In $ )\n");
        String inputExpenseAmount = scanner.next();
        if (CheckInput.checkInput(inputExpenseAmount)) {
            System.out.println("Example");
        } else {
            System.out.println("Oh no");
        }

        // TODO METHOD LOGIC
    }
    
    static void deleteExpense() {
        System.out.println("deleteExpense");
        // TODO METHOD LOGIC
    }
    
    static void viewExpenses() {
        System.out.println("viewExpenses");
        // TODO METHOD LOGIC
    }
    
    static void viewSummary() {
        System.out.println("viewSummary");
        // TODO METHOD LOGIC
    }
    
    static void viewSummaryPerMonth() {
        System.out.println("viewSummaryPerMonth");
        // TODO METHOD LOGIC
    }

}