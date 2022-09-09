package com.vin.array;

import com.vin.array.model.Node;

public class linkCode {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Node head = Utils.getHead(array);
        Node.print(rev1(head));
    }


    public static Node rev(Node head){
        Node t = null;
        while (head != null){
            Node temp = head.next;
            head.next = t;
            t = head;
            head = temp;
        }
        return t;
    }

    public static Node rev1(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node t = rev1(head.next);
        head.next.next = head;
        head.next = null;
        return t;
    }
}
