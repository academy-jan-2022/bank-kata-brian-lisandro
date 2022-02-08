package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TransactionsRepository {
    private TimeProvider timeProvider;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    public TransactionsRepository(TimeProvider timeProvider){
        this.timeProvider = timeProvider;
    }

    public void addDeposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(amount, timeProvider.now(), balance));
    }

    public void addWithdrawal(int amount) {
        balance -= amount;
        transactions.add(new Transaction(-amount, timeProvider.now(), balance));
    }

    public List<String> getStatementsList() {
        AtomicInteger runningBalance = new AtomicInteger();


        return this.transactions.stream()
            .map(transaction -> transaction.stringify())
            .collect(Collectors.toList());
    }
}
