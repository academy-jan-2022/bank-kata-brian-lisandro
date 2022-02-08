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
        var statementsList = transactionsRepository.getStatementsList();

        statementsList.add("Date || Amount || Balance");
        Collections.reverse(statementsList);

        return statementsList;
    }
}
