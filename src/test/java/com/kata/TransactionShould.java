package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionShould {
    @Test void
    get_amount(){
        var timeProviderMock = mock(TimeProvider.class);
        var transaction = new Transaction(100, timeProviderMock.now());

        var result = transaction.amount();

        assertEquals(100,  result);
    }

    @Test void
    get_date(){
        var timeProviderMock = mock(TimeProvider.class);
        String expectedDate = "10/01/2020";
        when(timeProviderMock.now()).thenReturn(expectedDate);
        var transaction = new Transaction(100, timeProviderMock.now());

        var result = transaction.date();

        assertEquals(expectedDate,  result);
    }
}
