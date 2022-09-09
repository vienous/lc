package com.vin.link;

import com.vin.Utils;
import com.vin.model.LinkNode;

public class LinkCode {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        LinkNode head = Utils.getHead(array);
        LinkNode newHead = rev(head);
        LinkNode.print(newHead);
        LinkNode.print(rev(newHead));
    }

    public static LinkNode rev(LinkNode head) {
        LinkNode t = null;
        while (head != null) {
            LinkNode temp = head.next;
            head.next = t;
            t = head;
            head = temp;
        }
        return t;
    }

    public static LinkNode rev1(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode t = rev1(head.next);
        head.next.next = head;
        head.next = null;
        return t;
    }
}
