import java.time.LocalDate;

public abstract class Transactions {
    protected String description; 
    protected double amount;
    protected LocalDate date;
    
    public Transactions(String description, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public abstract String getType();
    public abstract String getCategory();
}