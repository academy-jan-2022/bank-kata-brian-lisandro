package com.kata;

public record Money(int value) {
    public Money add(int amount) {
       return new Money(value + amount);
    }
}
