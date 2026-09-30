package account;

import client.Client;

public class CheckingAccount {
    private int accountNumber;
    private double balance;
    private double limit;

    private Client holder;

    public CheckingAccount(int accountNumber, double limit, Client holder) {
        this.accountNumber = accountNumber;
        this.limit = limit;
        this.holder = holder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && (this.balance + this.limit) >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

}
