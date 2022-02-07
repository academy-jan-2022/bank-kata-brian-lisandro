package com.kata;

public class Account {
    private final Transactions transactions;

    public Account(Transactions transactions) {
        this.transactions = transactions;
    }

    public void deposit(int amount) {
        transactions.addDeposit(amount);
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
