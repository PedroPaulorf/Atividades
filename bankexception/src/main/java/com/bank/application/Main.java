package com.bank.application;

import java.util.Scanner;

import com.bank.model.entities.Account;
import com.bank.model.exception.DomainException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank Application!");
        // You can add more functionality here as needed

        System.out.println("Enter account data: ");

        System.out.println("Account number: ");
        int accountNumber = sc.nextInt();

        System.out.println("Account Holder: ");
        String accountHolder = sc.next();

        System.out.println("Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.println("Withdraw Limit: ");
        double withdrawLimit = sc.nextDouble();

        System.out.println("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();

        try {
            Account acc = new Account(accountNumber, accountHolder, balance, withdrawLimit);

            acc.withdraw(withdrawAmount);
            System.out.println("Saque realizado com sucesso!");
            System.out.printf("New balance: %.2f%n", acc.getBalance());

        } catch (DomainException e) {
            System.out.println("Withdraw failed: " + e.getMessage());
        }
        sc.close();
    }
}
