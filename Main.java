import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        TransactionManager<Transactions> transactions = new TransactionManager<>();
        
        while(choice != 0){
            System.out.println("\n==== Welcome to your Personal Finance Manager! ====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Total Income/Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try{
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        // Add Income
                        System.out.println("Enter the descrpiption of the income: ");
                        String description = input.nextLine();
                        System.out.println("Enter the amount of the income: ");
                        double amount = Double.parseDouble(input.nextLine());
                        System.out.println("Enter the source of your income: ");
                        String source = input.nextLine();
                        Income newIncome = new Income(description, amount, LocalDate.now(), source);
                        transactions.addTransaction(newIncome);
                        System.out.println("Income added successfully!");
                        break;
                    case 2:
                        // Add Expense
                        System.out.println("Enter the description of the expense: ");
                        String expenseDescription = input.nextLine();
                        System.out.println("Enter the amount of the expense: ");
                        double expenseAmount = Double.parseDouble(input.nextLine());
                        System.out.println("Enter the category of your expense: ");
                        String category = input.nextLine();
                        Expenses newExpense = new Expenses(expenseDescription, expenseAmount, LocalDate.now(), category);
                        transactions.addTransaction(newExpense);
                        System.out.println("Expense added successfully!");
                        break;

                    case 3:
                        // View Transactions
                        System.out.println("All Transactions:");
                        for (Transactions transaction : transactions.getTransactions()) {
                           System.out.println(transaction);
                        }
                        break;


                    case 4:
                        // View Total Income/Expense
                        System.out.println("Total Income: " + transactions.getTotalAmountByType("Income"));
                        System.out.println("Total Expense: " + transactions.getTotalAmountByType("Expense"));
                        System.out.println("Net Total: " + (transactions.getTotalAmountByType("Income") - transactions.getTotalAmountByType("Expense")));
                        break;


                    case 5:
                        System.out.println("Exiting the program. Goodbye!");
                        choice = 0;
                        input.close();
                        break; 


                    default:

                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
            
        }

        input.close();
    }
}
