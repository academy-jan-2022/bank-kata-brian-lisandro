package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsRepository {
    private final TimeProvider timeProvider;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private Money balance = new Money(0);

    public TransactionsRepository(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void addDeposit(Money amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(amount, timeProvider.now(), balance));
    }

    public void addWithdrawal(Money amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(amount, timeProvider.now(), balance));
    }

    public List<String> getStatementsList() {
        return this.transactions.stream()
            .map(Transaction::stringify)
            .collect(Collectors.toList());
    }
}
