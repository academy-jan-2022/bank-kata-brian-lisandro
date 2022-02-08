package com.kata;

import java.util.ArrayList;

public class TransactionsRepository {
    private TimeProvider timeProvider;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public TransactionsRepository(TimeProvider timeProvider){
        this.timeProvider = timeProvider;
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(amount, timeProvider.now()));
    }

    public void addWithdrawal(int amount) {
        transactions.add(new Transaction(-amount, timeProvider.now()));
    }

    public ArrayList<Transaction> getAll() {
        return transactions;
    }
}
