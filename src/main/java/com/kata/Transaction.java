package com.kata;

public class Transaction {
    private final int amount;
    private final String date;

    public Transaction(int amount) {
        this.amount = amount;
        this.date = "10/01/2020";
    }

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date =  date;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }
}
