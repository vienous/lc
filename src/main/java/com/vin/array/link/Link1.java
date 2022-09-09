package com.vin.array.link;

import com.vin.array.model.Node;

public class Link1 {

    private static Node rev(Node head){
        Node r = null;
        while (head != null){
            Node temp = head.next;
            head.next = r;
            r = head;
            head = temp;
        }
        return r;
    }

    private static Node revd(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node node = revd(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
//        Node head = Node.getHead();
//        Node.print(head);
//        Node rev= revd(head);
//        Node.print(rev);
        AA qa = new AA();
        qa.start();
        System.out.println(1);
    }

    private static void FF(int a){
        assert a < 2:"aaaaa";
    }
}
