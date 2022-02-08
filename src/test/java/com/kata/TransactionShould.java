package com.kata;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionShould {
    @Test void
    stringify_transaction(){
        var timeProvider = mock(TimeProvider.class);
        when(timeProvider.now()).thenReturn("10/10/2019");

        var transaction  = new Transaction(new Money(100), timeProvider.now(), new Money(100));

        var result = transaction.stringify();

        assertEquals("10/10/2019 || 100 || 100", result);
    }
}
