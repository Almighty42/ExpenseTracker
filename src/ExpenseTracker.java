import java.util.ArrayList;
import util.CheckInput;
import util.Expenses;
import util.HandleExpenses;
import util.ShowOptions;

public class ExpenseTracker {
    public static void main(String[] args) {

        ArrayList<Expenses> expenseList = new ArrayList<>();
        
        ShowOptions.showOptions(0);

        int userChoice = CheckInput.handleUserInput();

        HandleExpenses.handleExpenses(userChoice, expenseList);

    }
}