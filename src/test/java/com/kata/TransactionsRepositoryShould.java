package com.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TransactionsRepositoryShould {
    @Mock TimeProvider timeProvider;

    @Test void
    take_a_deposit_request() {
        var transactions = new TransactionsRepository(timeProvider);

        transactions.addDeposit(1000);
        var result = transactions.getAll();
        var expected = new Transaction(1000, timeProvider.now());

        assertEquals(expected.getAmount(), result.get(0).getAmount());
    }

    @Test void
    take_a_withdrawal_request() {
        var transactions = new TransactionsRepository(timeProvider);

        transactions.addWithdrawal(100);
        var result = transactions.getAll();
        var expected = new Transaction(-100, timeProvider.now());

        assertEquals(expected.getAmount(), result.get(0).getAmount());
    }
}
