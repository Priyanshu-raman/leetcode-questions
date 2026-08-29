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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode revHead = reverse(head);
        if (n == 1) {
            revHead = revHead.next; 
        } else {
            ListNode curr = revHead;
            for (int i = 1; i < n - 1; i++) {
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }
        return reverse(revHead);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}