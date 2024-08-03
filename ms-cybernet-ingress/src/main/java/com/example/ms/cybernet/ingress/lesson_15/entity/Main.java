package com.example.ms.cybernet.ingress.lesson_15.entity;

public class Main {

    public static void main(String[] args) {

        Post p = new Post();
        Post q = new Post();
        p.setId(1L);
        q.setId(1L);


        System.out.println(p.getId() == q.getId());
        System.out.println(p.getId().equals(q.getId()));
        String a0 = "1st value";
        String a1 = "1st  value";
        System.out.println(a1.equals(a0));
        int a = 5, b = 5;
        System.out.println(a == b);
    }
}
