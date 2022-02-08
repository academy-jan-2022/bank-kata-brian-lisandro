package com.kata;

public record Transaction(int amount, String date) {
    public String stringify(){
        return date + " || " + amount + " || ";
    }
}
