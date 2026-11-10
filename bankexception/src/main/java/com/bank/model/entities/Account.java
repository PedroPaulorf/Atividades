package com.bank.model.entities;
import com.bank.model.exception.DomainException;

public class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    public double withdrawLimit;

    public Account() {

    }

    public Account(int accountNumber, String accountHolder, double balance, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    // aplicando exceções para o método withdraw
    public void withdraw(double amount) {
        if(!Double.isFinite(amount) || amount <= 0) {
            throw new DomainException("Invalid withdraw amount.");
        }
        if (amount > withdrawLimit) {
            throw new DomainException("Withdraw amount exceeds the limit.");
        }
        if (amount > balance) {
            throw new DomainException("Insufficient balance.");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                '}';
    }

}
