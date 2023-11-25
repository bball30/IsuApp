package com.example.demo1.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static final String errorDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(errorDateTimeFormat);
        return now.format(formatter);
    }
}
