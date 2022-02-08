package com.kata;

public record Money(int value) {
    public Money add(Money amount) {
       return new Money(value + amount.value());
    }
}
