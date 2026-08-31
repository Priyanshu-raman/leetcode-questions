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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int prevIndex = -1;
        int currentIndex = 1; 
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            boolean isCritical = (curr.val > prev.val && curr.val > curr.next.val) ||
                                 (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {
                if (firstIndex == -1) {
                    firstIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevIndex);
                }
                prevIndex = currentIndex;
            }

            prev = curr;
            curr = curr.next;
            currentIndex++;
        }
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}