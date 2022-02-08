package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    private List<String> generateStatement() {
        var statementsList = transactionsRepository.getAll();
        AtomicInteger runningBalance = new AtomicInteger();

        var statement = statementsList.stream().map(transaction -> {
            runningBalance.addAndGet(transaction.amount());
            return transaction.stringify() + runningBalance;
        }).collect(Collectors.toList());

        statement.add("Date || Amount || Balance");
        Collections.reverse(statement);

        return statement;
    }
}
