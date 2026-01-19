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

class Solution {
    public void reorderList(ListNode head) {
        ListNode first = head;
        ListNode last = null;
        int size = 0;
        while (head != null) { // count size
            if (head.next == null) last = head;
            head = head.next;
            size++;
        }
        head = first;

        int mid = size / 2;
        int index = 0;
        ListNode listA = head;
        ListNode listB = null;
        // System.out.println(head.val);
        while (index < mid) {
            ListNode goBack = listA;
            listA = listA.next;
            if (index + 1 == mid) {
                listB = listA.next;
                listA = goBack;
                listA.next = null;
            }
            // System.out.println(index);
            index++;
        }
        head = first;

        while (listA != null && listB != null) {
            ListNode listNextA = listA;
            ListNode listNextB = listB;

            if (listA.next != null) {
                listNextA = listA.next;
                 listA.next = listB;
            listA = listNextA;
            } else {
                break;
            }           

    if (listB.next != null) {
                listNextB = listB.next;
                 listB.next = listA;
            listB = listNextB;
            } else {
                break;
            }

           
        }
head = first;
        // listB = endOfFirstHalf.next;
        // ListNode reversedSecondHalf = reverseList(listB);

        // while (head != null && reversedSecondHalf != null) {
        //     ListNode saveFirstNext = head.next; // 4
        //     ListNode saveSecondNext = reversedSecondHalf.next; // 6

        //     head.next = reversedSecondHalf;
        //     reversedSecondHalf.next = head; // 6
        //     head = saveFirstNext;
        //     reversedSecondHalf = saveSecondNext;
        // }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
