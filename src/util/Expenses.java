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
    private LocalDate date;
    private String description;
    private float amount;
    private String category;

    // * Constructor
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
    
        // Define column widths
        int idWidth = 13;        // Width for ID column
        int dateWidth = 15;      // Width for Date column
        int descriptionWidth = 23; // Width for Description column
        int amountWidth = 10;    // Width for Amount column
    
        // Format the expense details with fixed-width columns
        return String.format(
            "%-" + idWidth + "s %-" + dateWidth + "s %-" + descriptionWidth + "s %-" + amountWidth + "s",
            uniqueID,
            date.format(formatter),
            truncateDescription(description, descriptionWidth),
            "$" + amount
        );
    }

    private String truncateDescription(String description, int maxWidth) {
        if (description.length() > maxWidth) {
            return description.substring(0, maxWidth - 3) + "..."; // Truncate and add ellipsis
        }
        return description;
    }

    public String getID() {
        return uniqueID;
    }

    public float getAmount() {
        return amount;
    }

    public int getMonth() {
        String monthName = date.getMonth().toString();
        switch (monthName) {
            case "JANUARY":
                return 1;
            case "FEBRUARY":
                return 2;
            case "MARCH":
                return 3;
            case "APRIL":
                return 4;
            case "MAY":
                return 5;
            case "JUNE":
                return 6;
            case "JULY":
                return 7;
            case "AUGUST":
                return 8;
            case "SEPTEMBER":
                return 9;
            case "OCTOBER":
                return 10;
            case "NOVEMBER":
                return 11;
            case "DECEMBER":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month name: " + monthName);
        }
    }

    // * Setters

    public void setExpense(String description, String category, float amount) {
        this.date = LocalDate.now();
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    // * Serialization / Deserialization

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

    // * Helper methods

    static String generateID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 8);
    }
}
