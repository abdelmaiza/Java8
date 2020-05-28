package com.cirta.software.date_and_time;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime localTime = LocalTime.of(23,10);
        System.out.println(localTime);
        localTime = localTime.plusHours(8);
        localTime = localTime.plusMinutes(25);
        System.out.println(localTime);
    }
}
