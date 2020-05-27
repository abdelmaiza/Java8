package com.cirta.software.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s -> s.length() <= 3;
        Predicate<String> p2 = s -> s.equals("two");

        List<String> result = new ArrayList<>();

        stream.peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(result::add);

        System.out.println("*************************************************");
        for (String r : result) {
            System.out.println(r);
        }
    }
}
