/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class LinkedList5 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode tempHead = head;
        int size = findSize(tempHead);
        int indexToReach = size - n;
        int index = 0;
        ListNode delete = head;
        ListNode left = null;

        while (index < indexToReach) {
            if (index + 1 == indexToReach) {
                left = delete;
            }
            delete = delete.next;
            index++;
        }

        if (left == null) {
            head = delete.next;
        } else {
            ListNode right = delete.next;
            left.next = right;
        }

        return head;
    }

    private int findSize(ListNode head) {
        int size = 1;
        while (head != null) { // 1 2 3
            size++;
            head = head.next;
            if (head == null || head.next == null) return size;
        }
        return size;
    }
}
