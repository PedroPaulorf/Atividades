package account;

import client.Client;

public class SavingsAccount {
    private int accountNumber;
    private double balance;
    private double yieldRate;

    private Client holder;

    public SavingsAccount(int accountNumber, Client holder, double yieldRate) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.yieldRate = yieldRate;
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

    public void applyYield() {
        balance = balance + (balance * yieldRate);
    }

    public double getBalance() {
        return balance;
    }

    public double getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(double yieldRate) {
        this.yieldRate = yieldRate;
    }

    //

}
