package com.example.ms.cybernet.ingress.lesson_15.entity;

import java.util.Objects;

public class Main {


    public static void main(String[] args) {
        char[] cr = {'k', 'e', 'l', 'e', 'm'};
        System.out.println(reverseString(cr));

    }

    public static ListNode middleNode(ListNode head) {

        var slow=head;
        var fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //    reversing char array using two pointer technique
    public static String reverseString(char[] value) {
        int start = 0;
        int end = value.length - 1;

        while (start < end) {
            char temp = value[start];
            value[start] = value[end];
            value[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(value);
    }

}
