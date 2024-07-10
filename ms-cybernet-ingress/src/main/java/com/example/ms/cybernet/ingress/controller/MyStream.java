package com.example.ms.cybernet.ingress.controller;

import org.apache.commons.lang3.stream.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] args) {
        Map<String,String> map=Map.of("5","qirmizi","3","Sari");
        List<Map<String,String>> dual=List.of(map);
        String value = dual.stream()
                .flatMap(innerMap -> innerMap.entrySet().stream()) // Stream entries
                .filter(entry -> entry.getValue().equals("Sari") && entry.getKey() > 5) // Filter by value and key
                .map(Map.Entry::getValue) // Get the value ("Sari") if found
                .findFirst() // Get the first matching element (or null if none found)
                .orElse(null); // R


        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    IntSummaryStatistics primesStatistics=    primes.stream().mapToInt(x->x)
                        .summaryStatistics();
        System.out.println(primesStatistics.getAverage());


        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .map(x -> x * 5)
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);


        List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");

        String capitalCountryNames = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(list + "\n" + capitalCountryNames);


        List<String> strList = Arrays.asList("azn", "", "eur", "", "tl", "lari");

        int b = myFilter(strList, x -> !x.isEmpty()).size(); // 1

        long a = strList.stream().filter(x -> !x.isEmpty()).count(); // 2


    }


    public static <T> List<T> myFilter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

}
