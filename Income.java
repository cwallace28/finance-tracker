import java.time.LocalDate;
public class Income extends Transactions {
    private String source;

    public Income(String description, double amount, LocalDate date, String source){
        super(description, amount, date);
        this.source = source;
    }

    @Override
    public String toString() {
        return "Income\n" +
                "  Description: " + description + "\n" +
                "  Amount: $" + amount + "\n" +
                "  Date: " + date + "\n" +
                "  Source: " + source;
    }

    @Override
    public String getType() {
        return "Income";
    }

    @Override
    public String getCategory() {
        return source;
    }

    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public String getAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }

    public String getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    public String getSource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSource'");
    }

}