import java.util.ArrayList;
import util.ApplicationInput;
import util.ApplicationMenu;
import util.Expenses;
import util.HandleExpenses;

public class ExpenseTracker {
    public static void main(String[] args) {

        // Defines list of expenses
        ArrayList<Expenses> expenseList = new ArrayList<>();
        
        // Displays application menu
        ApplicationMenu.showOptions(true);

        // Takes user-input and validates it
        int userChoice = ApplicationInput.handleOption();

        // Once user-input is validated, starts program
        HandleExpenses.handleExpenses(userChoice, expenseList);

    }
}