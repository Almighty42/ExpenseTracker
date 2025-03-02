package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Expenses implements Serializable {

    private final String uniqueID;
    private final LocalDate date;
    private final String description;
    private final float amount;
    private final String category;

    // Constructor
    public Expenses(String description, float amount, String category) {
        this.uniqueID = generateID();
        this.date = LocalDate.now();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // * Getters
    public String getExpense() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return uniqueID + "\t" + date.format(formatter) + "\t" + description + "\t\t" + "$" + amount;
        // TODO If there are spaces in the string, it doesn't get saved in the whole
    }

    public String getID() {
        return uniqueID;
    }

    public float getAmount() {
        return amount;
    }

    public static void saveExpense(Expenses expense) {
        try {
            ArrayList<Expenses> expenseList = loadExpenses();
            expenseList.add(expense);

            FileOutputStream fileOut = new FileOutputStream("ExpenseInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(expenseList);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateExpenses(ArrayList<Expenses> expenseList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("ExpenseInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(expenseList);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Expenses> loadExpenses() {
        try {
            ArrayList<Expenses> expenseList = new ArrayList<>();
            FileInputStream fileIn = new FileInputStream("ExpenseInfo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            expenseList = (ArrayList<Expenses>) in.readObject();
            System.out.println(expenseList.size());
            in.close();
            fileIn.close();
            return expenseList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    static String generateID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 8);
    }
}
