package com.kata;

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
        var output = new StringBuilder();
        output.append("Date       || Amount || Balance\n");
            var list = transactionsRepository.getAll();
            var runningBalance = 0;

        for (int i = 0; i < list.size(); i++) {
            Transaction transaction = list.get(i);
            runningBalance += transaction.getAmount();
            output.append(
                transaction.getDate() + " || " +
                    transaction.getAmount() + " || " +
                    runningBalance
            );

            if (i < list.size()) {
                output.append("\n");
            }
        }

        statementPrinter.print(output.toString());
    }
}
