package com.cirta.software.date_and_time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Person {
    private String name;
    private LocalDate dateOfBirth;
}
