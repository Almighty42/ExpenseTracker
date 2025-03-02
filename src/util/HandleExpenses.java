package util;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleExpenses {

    public static void handleExpenses(int userChoice, ArrayList<Expenses> expenseList, Scanner scanner) {
        if (userChoice == 1)
            addExpense(expenseList, scanner);
        if (userChoice == 2)
            deleteExpense(expenseList, scanner);
        if (userChoice == 3)
            viewExpenses(expenseList, scanner);
        if (userChoice == 4)
            viewSummary();
        if (userChoice == 5)
            viewSummaryPerMonth();
    }

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

        expenseDescription = scanner.next();
        scanner.nextLine();

        System.out.println("\nWhat category is the expense? \n");

        expenseCategory = scanner.next();
        scanner.nextLine();

        Expenses expense = new Expenses(expenseDescription, expenseAmount, expenseCategory);
        expenseList.add(expense);
        Expenses.saveExpense(expense);

        ApplicationMenu.clearConsole();
        System.out.println("Expense added to list!");
        ApplicationMenu.showOptions(false);
    }

    static void deleteExpense(ArrayList<Expenses> expenseList, Scanner scanner) {

        viewExpensesLoop(expenseList);

        System.out.println("\nSelect which expense to delete ( type in exact Expense ID ): \n");
        scanner.nextLine();
        String deleteExpenseID = scanner.nextLine();
        boolean isExpenseFound = ApplicationInput.handleExpenseDeletion(expenseList, deleteExpenseID);
        if (isExpenseFound) {
            System.out.println("\nExpense was found and deleted, press any button to continue...\n");
        } else {
            System.out.println("\nExpense was not found, press any button to continue...\n");
        }

        scanner.nextLine();

        ApplicationMenu.clearConsole();
        ApplicationMenu.showOptions(true);
    }

    static void viewExpenses(ArrayList<Expenses> expenseList, Scanner scanner) {

        viewExpensesLoop(expenseList);

        System.out.println("\nPress any button to continue...\n");
        scanner.nextLine();
        scanner.nextLine();

        ApplicationMenu.clearConsole();
        ApplicationMenu.showOptions(true);
    }

    static void viewExpensesLoop(ArrayList<Expenses> expenseList) {
        ApplicationMenu.clearConsole();

        System.out.println("# ID\t\tDate\t\tDescription\t\tAmount");
        for (int i = 0; i < expenseList.size(); i++) {
            Expenses expense = expenseList.get(i);
            System.out.println("# " + expense.getExpense());
        }
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