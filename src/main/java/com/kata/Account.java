package com.kata;

public class Account {
    private final Transactions transactions;
    private final StatementPrinter statementPrinter;

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

            for (Transaction transaction:list) {
                output.append(
                    transaction.getDate() + " || " +
                        transaction.getAmount() + " || " +
                        transaction.getBalance() + " || "
            );
        }

        StatementPrinter.print(output);
    }
}
