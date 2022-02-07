package com.kata;

public class Transaction {
    private final int amount;

    public Transaction(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public Object getBalance() {
        throw new UnsupportedOperationException();
    }

    public String getDate() {
        throw new UnsupportedOperationException();
    }
}
