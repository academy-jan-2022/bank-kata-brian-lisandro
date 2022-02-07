package com.kata;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Transaction> transactions;
    public void addDeposit(int amount) {
        this.transactions.add(new Transaction(amount));

    }

    public void addWithdrawal(int i) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Transaction> getAll() {
        throw new UnsupportedOperationException();
    }
}
