package com.kata;

import java.util.Collections;

public class Account {
    private final TransactionsRepository transactionsRepository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionsRepository transactionsRepository, StatementPrinter statementPrinter) {
        this.transactionsRepository = transactionsRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionsRepository.addTransaction(new Money(amount));
    }

    public void withdraw(int amount) {
        transactionsRepository.addTransaction(new Money(-amount));
    }

    public void printStatement() {
        var statement = transactionsRepository.getStatementsList();
        statement.add("Date || Amount || Balance");
        Collections.reverse(statement);

        statementPrinter.print(String.join("\n", statement));
    }
}
