package com.kata;

import java.util.ArrayList;
import java.util.Collections;

public class Account {
    private final TransactionsRepository transactionsRepository;
    private StatementPrinter statementPrinter;

    public Account(TransactionsRepository transactionsRepository, StatementPrinter statementPrinter) {
        this.transactionsRepository = transactionsRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionsRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionsRepository.addWithdrawal(amount);
    }

    public void printStatement() {
        var statement = generateStatement();

        statementPrinter.print(String.join("\n", statement));
    }

    private ArrayList<String> generateStatement() {
        var statement = new ArrayList<String>();
        var list = transactionsRepository.getAll();
        var runningBalance = 0;

        for (Transaction transaction : list) {
            runningBalance += transaction.amount();
            statement.add(transaction.stringify() + runningBalance);
        }

        statement.add("Date || Amount || Balance");
        Collections.reverse(statement);

        return statement;
    }
}
