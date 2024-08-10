package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.Arrays;
import java.util.Objects;

public class Main {


    public static void main(String[] args) {
       int[] seats = {4,1,5,9}, students = {1,3,2,6};
        System.out.println(minMovesToSeat(seats, students));

    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int count=0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i=0;i<seats.length;i++){
            count+=Math.abs(students[i]-seats[i]);
        }
        return count;
    }


}
