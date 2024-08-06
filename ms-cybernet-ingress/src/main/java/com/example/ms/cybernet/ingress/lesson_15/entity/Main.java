package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.Objects;

public class Main {


    //    reversing char array using two pointer technique
    public static String reverseString(char[] value) {
        int start = 0;
        int end = value.length - 1;
        char temp;
        while (start < end) {
            temp = value[start];
            value[start] = value[end];
            value[end] = temp;

        }
        return value.toString();
    }


    public static void main(String[] args) {
        char[] cr = {'k', 'e', 'l', 'e', 'm'};
        System.out.println(reverseString(cr));


    }
}
