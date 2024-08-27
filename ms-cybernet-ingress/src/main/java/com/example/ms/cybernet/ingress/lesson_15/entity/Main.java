package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Main {


    public static void main(String[] args) {
//        fib(3);
    //    System.out.println(tribonacci(4));
List<Integer> nums=List.of(4,6,10);

        System.out.println(sumPossible(15,nums));
    }


    //Sum Possible
    public static boolean sumPossible(int amount , List<Integer> numbers){
        return sumPossible(amount,numbers, new HashMap<>());
    }

    public static boolean sumPossible(int amount , List<Integer> numbers, HashMap<Integer,Boolean> memo){
        if (amount==0) return true;
        if(amount<0) return false;

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        for(int num:numbers){
            int sumAmount=amount-num;
            if(sumPossible(sumAmount,numbers,memo)){
                memo.put(amount,true);
                return true;
            }
        }
        return false;
    }

    //Tribonacci

    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 ) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, result);
        return result;
    }

    // 1 fibonacci
    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, result);
        return result;
    }


    public static int minimumSum(int num) {
        int p1 = num / 1000;
        int p2 = num / 100 % 10;
        int p3 = num / 10 % 10;
        int p4 = num % 10;
        int[] digits = {p1, p2, p3, p4};
        Arrays.sort(digits);
        int minimumSum = digits[0] * 10 + digits[3] + digits[1] * 10 + digits[2];
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
