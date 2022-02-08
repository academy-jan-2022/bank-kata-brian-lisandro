package com.kata;

public final class Transaction {
    private final Money amount;
    private final String date;
    private Money runningBalance;

    public Transaction(Money amount, String date, Money runningBalance) {
        this.amount = amount;
        this.date = date;
        this.runningBalance = runningBalance;
    }

    public String stringify() {
        return date + " || " + amount.value() + " || " + runningBalance.value();
    }
}
