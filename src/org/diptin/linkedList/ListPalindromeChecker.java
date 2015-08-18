package org.diptin.linkedList;

/**
 * Created by dipti on 7/14/15.
 */
public class ListPalindromeChecker {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode l1 = head;
        ListNode prev = getSecondHalfList(head);
        ListNode l2 = reverseList(prev.next, null);
        if (prev != null) {
            prev.next = null;
        }
        return compareLists(l1, l2);
    }

    private boolean compareLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 != null || head2 != null) {
            return false;
        }
        return true;
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode nextNode = head.next;
        head.next = prev;
        return reverseList(nextNode, head);
    }

    private ListNode getSecondHalfList(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode prev = node1;

        while (node2 != null && node2.next != null) {
            prev = node1;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if (node2 != null && node2.next == null) {
            prev.next = node1.next;
        }
        return prev;
    }
}
