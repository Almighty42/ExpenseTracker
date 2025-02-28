package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Expenses implements Serializable {
    
    private String uniqueID;
    private Date date;
    private String description;
    private float amount;
    private String category;

    // Constructor
    public Expenses(String description, float amount, String category) {
        this.uniqueID = UUID.randomUUID().toString();
        // TODO Fix Date format
        this.date = new Date();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getter
    public String getExpense() {
        return uniqueID + "\t" + date + "\t" + description + "\t" + "$" + amount;
    }

    public static void saveExpense(Expenses expense) {
        try {
            FileOutputStream fileOut = new FileOutputStream("ExpenseInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            ArrayList<Expenses> expenseList = loadExpenses();
            out.writeObject(expenseList.add(expense));
            out.close(); fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Expenses> loadExpenses() {
        try {
            ArrayList<Expenses> expenseList = new ArrayList<>();
            File file = new File("ExpenseInfo.ser");
            // TODO Create a check if ExpenseInfo.ser exists and how to handle diffrent scenarios

            FileInputStream fileIn = new FileInputStream("ExpenseInfo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            expenseList = (ArrayList<Expenses>) in.readObject();
            System.out.println(expenseList.size());
            in.close(); fileIn.close();
            return expenseList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // TODO Create a method that returns a unique short ID
}
