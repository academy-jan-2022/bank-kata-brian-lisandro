package com.kata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider {
    public String now(){
        var formattedDate = DateTimeFormatter.ofPattern("dd/mm/yyyy").format(LocalDateTime.now());

        return formattedDate;
    }
}
