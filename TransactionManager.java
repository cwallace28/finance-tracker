import java.io.BufferedWriter;
import java.io.FileWriter;
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



    public double getTotalIncome(){
        double totalIncome = 0;
        for (T transaction : transactions){
            if (transaction instanceof Income){
                totalIncome += transaction.amount;
            }
        }
        return totalIncome;
    }
    

    public double getTotalExpense(){
        double totalExpense = 0;
        for (T transaction : transactions){
            if(transaction instanceof Expenses){
                totalExpense += transaction.amount;
            }
        }
        return totalExpense;

    }



    public double getNetBalance(){
        return getTotalIncome() - getTotalExpense();
    }


    public void saveToFile(String incomingFilePath, String expenseFilePath){
        // Implement file saving logic here
        try (
            BufferedWriter incomingWriter = new BufferedWriter(new FileWriter(incomingFilePath));
            BufferedWriter expenseWriter = new BufferedWriter(new FileWriter(expenseFilePath))
        ) {
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(expenseFilePath + " not found.");
        }

        
    }

    public void loadFromFile(String incomingFilePath, String expenseFilePath){
        // Implement file loading logic here

    }


}
