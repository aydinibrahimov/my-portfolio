package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        Integer i1 = 128, i2 = 10;
        Integer i3 = 127, i4 = 127;
        Integer i5 = 127;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i5 == i4);
        minimumSum(1994);

    }


    public static int minimumSum(int num) {
        int p1 = num / 1000;
        int p2 = num / 100 % 10;
        int p3 = num / 10 % 10;
        int p4 = num % 10;
        int[] digits = {p1, p2, p3, p4};
        Arrays.sort(digits);
        int minimumSum = digits[0]*10+digits[2]+digits[1]*10+digits[3];
        return minimumSum;
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int count = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(students[i] - seats[i]);
        }

        return count;
    }


    public int countPairs(List<Integer> nums, int target) {

        int count = 0;
        int n = nums.size();

        for (int i = 0; i < n - 2; i++) {
            boolean s = nums.contains(target - nums.get(i));
            if (s) count++;
        }
        return count;


    }

}
