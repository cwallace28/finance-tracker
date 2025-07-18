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
            System.out.println("5. View Total");
            System.out.println("6. Save and Exit");
            System.out.println("===============================================");
            System.out.print("Enter your choice: ");

            try{
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        // Add Income
                        System.out.println("Enter the description of the income: ");
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
                        System.out.println("Total Income: $" + transactions.getTotalAmountByType("Income"));
                        System.out.println("Total Expense: $" + transactions.getTotalAmountByType("Expense"));
                        System.out.println("Net Total: $" + (transactions.getTotalAmountByType("Income") - transactions.getTotalAmountByType("Expense")));
                        break;

                    
                    case 5:
                        // View Total
                        System.out.println("What would you like to view the total of?");
                        System.out.println("1. Total Income");
                        System.out.println("2. Total Expense");
                        System.out.println("3. Net Total");

                        int totalChoice = Integer.parseInt(input.nextLine());
                        switch (totalChoice) {
                            case 1:
                                System.out.println("Total Income: $" + transactions.getTotalIncome());
                                break;
                            case 2:
                                System.out.println("Total Expense: $" + transactions.getTotalExpense());
                                break;
                            case 3:
                                System.out.println("Net Total: $" + (transactions.getTotalIncome() - transactions.getTotalExpense()));
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case 6:
                        System.out.println("Are you sure you want to save and exit the program?  Be sure that you've added everything you wanted to keep in check of! (yes/no)");
                        String confirm = input.nextLine();
                        if (!confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Exiting without saving.");
                            continue; // Go back to the main menu
                        } else {
                            System.out.println("Saving transactions and exiting the program. Please wait a moment..");
                            // Here the saveToFile method would be called to save the transactions in their own respective files.
                            transactions.saveToFile("income.txt", "expense.txt");
                            // Printing Message to indicate successful saving of transactions.
                            System.out.println("Transactions saved successfully! Exiting the program");
                        }
                        break;
                    case 7:
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
