package com.kata;

import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsShould {
    @Test void
    take_a_deposit_request() {
        var transactions = new Transactions();
        transactions.addDeposit(1000);
        var result = transactions.getAll();
        var expected = new Transaction(1000);
        assertEquals(expected.getAmount(), result.get(0).getAmount());
    }
}
