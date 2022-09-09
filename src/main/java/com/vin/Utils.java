package com.vin;

import com.vin.model.LinkNode;

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


    public static LinkNode getHead(int[] array) {
        LinkNode head = new LinkNode(array[0]);
        LinkNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new LinkNode(array[i]);
            temp = temp.next;
        }
        return head;
    }
}
