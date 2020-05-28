package com.cirta.software.date_and_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    public static void main(String[] args) {
        ZonedDateTime currentMeting = ZonedDateTime.of(
                LocalDate.of(2020,05,28),
                LocalTime.of(12,00,00),
                ZoneId.of("Europe/Paris"));

        ZonedDateTime currentMetingUS = currentMeting.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(currentMetingUS));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(currentMetingUS));
    }
}
