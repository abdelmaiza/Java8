package com.cirta.software.date_and_time;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class DataAndTime {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(Objects.requireNonNull(DataAndTime.class.getClassLoader().getResourceAsStream("peopledate.txt"))));
            Stream<String> lines =  reader.lines();
        ) {
            lines.map(createPerson(people))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate now = LocalDate.now();
        people.stream().forEach(person -> {
            Period period = person.getDateOfBirth().until(now);
            System.out.println(person.getName() + " has :  "
                    + period.getYears() + " years and " +
                            period.getMonths() + " months " +
                    "[" + person.getDateOfBirth().until(now , ChronoUnit.MONTHS) + " months]"
                    );
        });

        // see TemporalAdjuster class
    }

    private static Function<String, Person> createPerson(List<Person> people) {
        return line -> {
            String[] s = line.split(" ");
            Person person = new Person(s[0].trim(), LocalDate.of(Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3])));
            people.add(person);
            return person;
        };
    }
}
