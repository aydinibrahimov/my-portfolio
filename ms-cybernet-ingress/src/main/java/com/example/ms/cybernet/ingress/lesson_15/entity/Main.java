package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.Objects;

public class Main {

    Long q=5L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return Objects.equals(q, main.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(q);
    }

    public static void main(String[] args) {
//        Object o1=new Object();
//        Object o2=new Object();
//        System.out.println(o2.equals(o1));


        String str1 ="Hello";
        String str2 = "Hello";
        System.out.println(str1==str2);

    }
}
