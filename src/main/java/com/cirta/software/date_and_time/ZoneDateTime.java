package com.cirta.software.date_and_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneDateTime {
    public static void main(String[] args) {
        final Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        //availableZoneIds.forEach(System.out::println);

        final ZoneId zoneId = ZoneId.of("Europe/Paris");
        System.out.println(zoneId.getId());

        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.of("Africa/Algiers")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/London")));
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));


        ZonedDateTime currentMeting = ZonedDateTime.of(
                LocalDate.of(2020,05,28),
                LocalTime.of(12,46,00),
                ZoneId.of("Europe/Paris"));
        System.out.println("####################################################");
        System.out.println("currentMeting : " + currentMeting);
        ZonedDateTime nextWeekMeting1 = currentMeting.plusWeeks(1);
        ZonedDateTime nextWeekMeting2 = currentMeting.plus(Period.ofWeeks(1));

        ZonedDateTime nextMonthMeting1 = currentMeting.plusMonths(1);
        ZonedDateTime nextMonthMeting2 = currentMeting.plus(Period.ofMonths(1));

        System.out.println("nextWeekMeting1 : " + nextWeekMeting1);
        System.out.println("nextWeekMeting2 : " + nextWeekMeting2);
        System.out.println("nextMonthMeting1 : " + nextMonthMeting1);
        System.out.println("nextMonthMeting1 : " + nextMonthMeting2);


        ZonedDateTime currentMetingUS = currentMeting.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println("nextWeekMetingUS : "  + currentMetingUS);
    }
}
