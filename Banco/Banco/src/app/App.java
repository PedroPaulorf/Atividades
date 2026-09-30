package app;

import java.util.Locale;
import java.util.Scanner;

import account.CheckingAccount;
import account.InvestmentAccount;
import account.SavingsAccount;
import client.Client;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int accountNumber;
        double amount;

        System.out.println("============================");
        System.out.println(" BANKING SYSTEM - REGISTER");
        System.out.println("============================");

        System.out.println("Enter the client name: ");
        String name = sc.nextLine();

        System.out.println("Enter the customer cpf: ");
        String cpf = sc.nextLine();

        System.out.println("Enter the customer email: ");
        String email = sc.nextLine();

        Client client = new Client(name, cpf, email);

        System.out.println("[SUCESS] Customer successfully registered");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("ACCOUNT OPENING MENU");
            System.out.println();
            System.out.println("Select the type od account you wish to open: ");
            System.out.println("[1] - Cheking Account");
            System.out.println("[2] - Savings Account");
            System.out.println("[3] - Investmen Account");
            System.out.println("[0] -  Exit");
            System.out.println("Enter the option:");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    // bloco de coleta de infs
                    System.out.println("Chosen option: [" + opcao + "]");
                    System.out.println("Enter the number for the new account: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the overdraft limit: ");
                    double limit = sc.nextDouble();
                    sc.nextLine();

                    CheckingAccount checking = new CheckingAccount(accountNumber, limit, client);

                    System.out.println();
                    System.out.println("[SUCESS] Checking account successfully created!");
                    System.out.println();

                    // operacionando a conta
                    System.out.println("Enter an amount to make the first deposit:");
                    amount = sc.nextDouble();
                    checking.deposit(amount);
                    sc.nextLine();

                    System.out.println("[OPERATION] Deposit of R$" + amount + " completed!");

                    System.out.println("Enter an amount to withdrawal:");
                    amount = sc.nextDouble();
                    sc.nextLine();

                    if (checking.withdraw(amount)) {
                        System.out.println("[OPERATION] Withdrawal approved! New balance: R$" + checking.getBalance());
                    } else {
                        System.out.println("[ERROR] Insufficient balance/limit for this withdrawal.");
                    }
                    break;

                case 2:

                    System.out.println("Chosen option: [" + opcao + "]");

                    System.out.println("Enter the number for the new account: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the monthly yield rate: ");
                    double yieldRate = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("");

                    SavingsAccount savings = new SavingsAccount(accountNumber, client, yieldRate);

                    System.out.println("[SUCESS] Savings account successfully created!");

                    System.out.println("Enter an amount to make the first deposit:");
                    amount = sc.nextDouble();
                    savings.deposit(amount);
                    sc.nextLine();

                    System.out.println("[OPERATION] Deposit of R$" + amount + " completed!");

                    System.out.println("Applying monthly yield...");
                    savings.applyYield();
                    System.out.printf("[OPERATION] Yield applied! New balance: R$%.2f%n", savings.getBalance());

                    System.out.println("Enter an amount to withdrawal:");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    if (savings.withdraw(amount)) {
                        System.out.println("[OPERATION] Withdrawal approved! New balance: R$" + savings.getBalance());
                    } else {
                        System.out.println("[ERROR] Insufficient balance/limit for this withdrawal.");
                    }
                    break;

                case 3:
                    System.out.println("Chosen option: [" + opcao + "]");

                    System.out.println("Enter the number for the new account: ");
                    accountNumber = sc.nextInt();
                    sc.nextLine();

                    InvestmentAccount investment = new InvestmentAccount(accountNumber, client);

                    System.out.println("[SUCESS] Investment account successfully created!");

                    // operacoes

                    System.out.println("Enter an amount to make the first deposit:");
                    amount = sc.nextDouble();
                    investment.deposit(amount);
                    sc.nextLine();

                    System.out.println("[OPERATION] Deposit of R$" + amount + " completed!");
                    System.out.println();

                    System.out.println("Enter today's yield rate :");
                    double rate = sc.nextDouble();
                    investment.applyYield(rate);
                    sc.nextLine();

                    System.out.println(" yield applied! New balance: " + investment.getBalance());

                    System.out.println("Enter an amount to test the withdrawal: ");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    if (investment.withdraw(amount)) {
                        System.out
                                .println("[OPERATION] Withdrawal approved! New balance: R$" + investment.getBalance());
                    } else {
                        System.out.println("[ERROR] Insufficient balance/limit for this withdrawal.");
                    }

                    System.out.println();

                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
