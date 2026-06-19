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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // 1. Create a dummy node to cleanly handle edge case where left = 1 (reversing from head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 2. Move 'prev' pointer to the node exactly before the reversal zone
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 'start' points to the first node of the sub-list to be reversed
        ListNode start = prev.next; 
        // 'then' points to the node that will be brought to the front of the sub-list
        ListNode then = start.next; 

        // 3. Reverse the sub-list iteratively
        // Example: prev -> 1, start -> 2, then -> 3
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}