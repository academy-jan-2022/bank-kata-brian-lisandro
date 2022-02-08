package com.kata;

public final class Transaction {
    private final int amount;
    private final String date;
    private int runningBalance;

    public Transaction(int amount, String date, int runningBalance) {
        this.amount = amount;
        this.date = date;
        this.runningBalance = runningBalance;
    }

    public String stringify() {
        return date + " || " + amount + " || " + runningBalance;
    }
}
