import java.time.LocalDate;

public class Expenses extends Transactions {

    private String category;
        public Expenses(String description, double amount, LocalDate date, String category){
            super(description, amount, date);
            this.category = category;
    }

    @Override
    public String toString() {
        return "Expense\n" +
                "  Description: " + description + "\n" +
                "  Amount: $" + amount + "\n" +
                "  Date: " + date + "\n" +
                "  Category: " + category;
    }

    @Override
    public String getType() {
        return "Expense";
    }
    @Override
    public String getCategory() {
        return this.category;
    }
}
