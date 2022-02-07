package com.kata;

public class Transaction {
    private final int amount;

    public Transaction(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getDate() {
        return "10/01/2020";
    }
}
