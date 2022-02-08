package com.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionsRepositoryShould {
    @Mock TimeProvider timeProvider;

    @Test void
    take_a_deposit_request() {
        var transactions = new TransactionsRepository(timeProvider);
        when(timeProvider.now()).thenReturn("10/01/2020");

        transactions.addDeposit(1000);
        var result = transactions.getStatementsList();
        var expected = new Transaction(new Money(1000), timeProvider.now(), new Money(1000));

        assertEquals(expected.stringify(), result.get(0));
    }

    @Test void
    take_a_withdrawal_request() {
        var transactions = new TransactionsRepository(timeProvider);
        when(timeProvider.now()).thenReturn("10/01/2020");

        transactions.addWithdrawal(100);
        var result = transactions.getStatementsList();
        var expected = new Transaction(new Money(-100), timeProvider.now(), new Money(-100));

        assertEquals(expected.stringify(), result.get(0));
    }
}
