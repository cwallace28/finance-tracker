import java.util.ArrayList;
import java.util.List;

public class TransactionManager<T extends Transactions>  {
    private List<T> transactions = new ArrayList<>();

    public void addTransaction(T transaction) {
        transactions.add(transaction);
    }
    public void removeTransaction(T transaction) {
        transactions.remove(transaction);
    }
    public List<T> getTransactions() {
        return transactions;
    }

    public double getTotalAmount() {
        double total = 0;
        for (T transaction : transactions) {
            total += transaction.amount;
        }
        return total;
    }
    public double getTotalAmountByType(String type) {
        double total = 0;
        for (T transaction : transactions) {
            if (transaction.getType().equals(type)) {
                total += transaction.amount;
            }
        }
        return total;
    }
    public double getTotalAmountByCategory(String category) {
        double total = 0;
        for (T transaction : transactions) {
            if (transaction.getCategory().equals(category)) {
                total += transaction.amount;
            }
        }
        return total;
    }
    
}
