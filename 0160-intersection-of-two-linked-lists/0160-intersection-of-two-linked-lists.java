/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curr = headA;
        ListNode cur = headB;
        while (curr != cur) {
            curr = (curr == null) ? headB : curr.next;
            cur = (cur == null) ? headA : cur.next;
        }

        return curr;
    }
}