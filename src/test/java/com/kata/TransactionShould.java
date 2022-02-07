package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionShould {
    @Test void
    get_amount(){
        var transaction = new Transaction(100);
        var result = transaction.getAmount();
        assertEquals(100,  result);
    }

    @Test void
    get_date(){
        var transaction = new Transaction(100);
        var result = transaction.getDate();
        assertEquals("10/01/2020",  result);
    }
}
