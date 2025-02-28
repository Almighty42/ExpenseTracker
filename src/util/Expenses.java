package util;
import java.util.Date;
import java.util.UUID;

public class Expenses {
    
    private String uniqueID;
    private Date date;
    private String description;
    private float amount;
    private String category;

    // Constructor
    public Expenses(String description, float amount, String category) {
        this.uniqueID = UUID.randomUUID().toString();
        this.date = new Date();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getter
    public String returnExpense() {
        return uniqueID + "\t" + date + "\t" + description + "\t" + "$" + amount;
    }
}
