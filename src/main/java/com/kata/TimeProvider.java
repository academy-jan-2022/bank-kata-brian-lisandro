package com.kata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider {
    public String now(){
        return DateTimeFormatter
            .ofPattern("dd/mm/yyyy")
            .format(LocalDateTime.now());
    }
}
