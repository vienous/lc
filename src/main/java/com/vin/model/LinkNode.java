package com.vin.model;

public class LinkNode {
    public int value;
    public LinkNode next;

    public LinkNode(int value) {
        this.value = value;
    }

    public static void print(LinkNode head) {
        while (head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
        System.out.println();
    }
}
