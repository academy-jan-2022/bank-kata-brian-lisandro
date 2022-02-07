package com.kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest {
    @Test void
    acceptance_test(){
        var output =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var transactions = new Transactions();
        var statementPrinter = new StatementPrinter();
        var account = new Account(transactions, statementPrinter);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        var finalOutput = output.toString();
        var expected = "Date       || Amount || Balance\n" +
            "14/01/2012 || -500   || 2500\n" +
            "13/01/2012 || 2000   || 3000\n" +
            "10/01/2012 || 1000   || 1000";

        assertEquals(expected, finalOutput);
    }
}
