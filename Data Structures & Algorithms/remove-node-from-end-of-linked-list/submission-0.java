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
    public int findLength(ListNode head){
        int i = 0;
        while(head!= null){
            head = head.next;
            i++;
        }

        return i;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = findLength(head);
        int k = len - n;

        if(k == 0) { return head.next;}

        ListNode curr = head;
        ListNode prev = null;

        while(k>0){
            prev = curr;
            curr = curr.next;
            k--;
        }

        prev.next = curr.next;

        return head;
        
    }
}
