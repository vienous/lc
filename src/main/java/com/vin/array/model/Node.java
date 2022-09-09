package com.vin.array.model;


public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static void print(Node head) {
        while (head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
        System.out.println();
    }
}
