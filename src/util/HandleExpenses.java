package util;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleExpenses {

    public static void handleExpenses(int userChoice, ArrayList<Expenses> expenseList, Scanner scanner) {
        if (userChoice == 1) addExpense(expenseList, scanner);
        if (userChoice == 2) deleteExpense();
        if (userChoice == 3) viewExpenses();
        if (userChoice == 4) viewSummary();
        if (userChoice == 5) viewSummaryPerMonth();
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

        ApplicationMenu.clearConsole();
        System.out.println("Expense added to list!");
        ApplicationMenu.showOptions(false);

        // TODO Add saving via serialization logic to code...

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