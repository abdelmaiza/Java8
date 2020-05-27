package com.cirta.software.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(12,12,12);
        Integer sum = integers.stream()
                .reduce(0, Integer::sum);

        Optional<Integer> max = integers.stream()
                .reduce(Integer::max);

        System.out.println("sum : " + sum);
        System.out.println("max : " + max.orElse(0));
    }
}
