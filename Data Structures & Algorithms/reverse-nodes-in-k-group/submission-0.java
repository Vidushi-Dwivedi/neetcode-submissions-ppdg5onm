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
    public ListNode reverse(ListNode head, ListNode nextGrp){
        ListNode curr = head;
        ListNode prev = nextGrp; // Start prev at nextGrp to attach the remaining list

        while(curr != nextGrp){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // This will be the new head of the reversed segment
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode grpPrev = dummy;

        while(true){
            ListNode kth = getKthNode(grpPrev, k);

            if (kth == null) {
                break; // Remaining nodes are fewer than k, leave unchanged
            }

            ListNode nextGrp = kth.next;
            reverse(grpPrev.next, nextGrp);

            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }

        return dummy.next;
    }
}
