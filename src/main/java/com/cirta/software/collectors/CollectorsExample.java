package com.cirta.software.collectors;

import com.cirta.software.collectors.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {
    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(Objects.requireNonNull(CollectorsExample.class.getClassLoader().getResourceAsStream("people.txt"))));
             Stream<String> stream = reader.lines();
        ){
            stream.map(createPerson(people))
                    .forEach(System.out::println);
        }

        System.out.println("##########################################################");
        Optional<Person> optMin = people.stream().filter(person -> person.getAge() < 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println(optMin);

        System.out.println("##########################################################");
        Optional<Person> optMax = people.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(optMax);

        System.out.println("##########################################################");
        Map<Integer, List<Person>> collect1 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect1);

        System.out.println("##########################################################");
        Map<Integer, Long> collect2 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(collect2);

        System.out.println("##########################################################");
        Map<Integer, List<String>> collect3 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(collect3);

        System.out.println("##########################################################");
        Map<Integer, Set<String>> collect4 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
        System.out.println(collect4);

        System.out.println("##########################################################");
        Map<Integer,String> collect5 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(","))));
        System.out.println(collect5);
    }

    private static Function<String, Person> createPerson(List<Person> people) {
        return line -> {
            String[] s = line.split(" ");
            Person person = new Person(s[0].trim(), Integer.parseInt(s[1]));
            people.add(person);
            return person;
        };
    }
}
