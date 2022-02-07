package com.kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTest {
    @Test void
    acceptance_test(){
        var transactions = new Transactions();
        var statementPrinter = new StatementPrinter();
        var account = new Account(transactions, statementPrinter);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        var output =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        var finalOutput = output.toString();
        var expected = "Date       || Amount || Balance\n" +
            "14/01/2012 || -500   || 2500\n" +
            "13/01/2012 || 2000   || 3000\n" +
            "10/01/2012 || 1000   || 1000";

        assertEquals(expected, finalOutput);
    }

}

/*
public interface AccountService
{
    void deposit(int amount)
    void withdraw(int amount)
    void printStatement()
}
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
Then they would see:

Date       || Amount || Balance
14/01/2012 || -500   || 2500
13/01/2012 || 2000   || 3000
10/01/2012 || 1000   || 1000
 */
