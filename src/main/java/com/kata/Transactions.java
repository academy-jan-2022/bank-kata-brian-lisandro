package com.kata;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addDeposit(int amount) {
        transactions.add(new Transaction(amount));
    }

    public void addWithdrawal(int amount) {
        transactions.add(new Transaction(-amount));
    }

    public ArrayList<Transaction> getAll() {
        return transactions;
    }
}
