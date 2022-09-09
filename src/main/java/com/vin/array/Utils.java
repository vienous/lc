package com.vin.array;

import com.vin.array.model.Node;

public class Utils {
    public static void fg(int i) {
        System.out.println("======================= " + i + " ==========================");
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            String a = String.format("%2d  ", i);
            System.out.print(a);
        }
        System.out.println();
    }

    public static void printArray(long[] array) {
        for (long i : array) {
            String a = String.format("%2d  ", i);
            System.out.print(a);
        }
        System.out.println();
    }


    public static Node getHead(int[] array) {
        Node head = new Node(array[0]);
        Node temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new Node(array[i]);
            temp = temp.next;
        }
        return head;
    }
}
