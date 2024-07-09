package com.example.ms.cybernet.ingress.controller;

import org.apache.commons.lang3.stream.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long a = strList.stream().map(x -> !x.isEmpty()).count();
        long b = strList.stream().map(Streams::nonNull).count();
        System.out.println("My outputs " + a + " " + b);
    }
}
