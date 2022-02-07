package com.kata;

public class Account {
    private final Transactions transactions;
    private StatementPrinter statementPrinter;

    public Account(Transactions transactions, StatementPrinter statementPrinter) {
        this.transactions = transactions;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactions.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactions.addWithdrawal(amount);
    }

    public void printStatement() {
        var output = new StringBuilder();
        output.append("Date       || Amount || Balance\n");
            var list = transactions.getAll();
            var runningBalance = 0;

            for (Transaction transaction:list) {
                runningBalance += transaction.getAmount();
                output.append(
                    transaction.getDate() + " || " +
                        transaction.getAmount() + " || " +
                        runningBalance + " || "
            );
        }

        statementPrinter.print(output.toString());
    }
}
