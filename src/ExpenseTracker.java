import java.util.ArrayList;
import java.util.Scanner;
import util.*;

public class ExpenseTracker {
    public static void main(String[] args) {

        // Defines list of expenses
        ArrayList<Expenses> expenseList = Expenses.loadExpenses();
        
        // Displays application menu
        ApplicationMenu.showOptions(true);

        // Defines scanner, so that it can be closed in Main
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            // Takes user-input and validates it
            int userChoice = ApplicationInput.handleOption(scanner);
    
            // Once user-input is validated, starts program
            HandleExpenses.handleExpenses(userChoice, expenseList, scanner);            
        }


    }
}