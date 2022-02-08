package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsRepository {
    private TimeProvider timeProvider;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Money balance = new Money(0);

    public TransactionsRepository(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void addDeposit(int amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(new Money(amount), timeProvider.now(), balance));
    }

    public void addWithdrawal(int amount) {
        balance = balance.add(-amount);
        transactions.add(new Transaction(new Money(-amount), timeProvider.now(), balance));
    }

    public List<String> getStatementsList() {
        return this.transactions.stream()
            .map(Transaction::stringify)
            .collect(Collectors.toList());
    }
}
