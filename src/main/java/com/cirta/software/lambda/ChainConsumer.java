package com.cirta.software.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {
    public static void main(String [] args){
        List<String> list = Arrays.asList("one","two","tree","four","five");
        List<String> result = new ArrayList<>();
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer2 = result::add;
        list.forEach(consumer1.andThen(consumer2));

        System.out.println(result.size());

    }
}
