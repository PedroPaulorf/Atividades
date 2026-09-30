package account;

import client.Client;

public class InvestmentAccount {
    private int accountNumber;
    private double balance;

    private Client holder;

    public InvestmentAccount(int accountNumber, Client holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
    }

    public void applyYield(double rate) {
        balance += balance * rate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
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

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }
}
