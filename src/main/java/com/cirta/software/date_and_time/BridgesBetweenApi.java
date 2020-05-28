package com.cirta.software.date_and_time;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BridgesBetweenApi {
    public static void main(String[] args) {
        //How to inter operate with the legacy Date API

        //Instant and Date
        Instant instant = Instant.now();
        Date date = Date.from(instant);  //API -> Legacy
        Instant instant1 = date.toInstant(); // legacy -> API

        //Instant and TimeStamp
        Timestamp time = Timestamp.from(instant); //API -> Legacy
        Instant instant2 = time.toInstant(); // legacy -> API

        //LocalDate and Date

    }
}
