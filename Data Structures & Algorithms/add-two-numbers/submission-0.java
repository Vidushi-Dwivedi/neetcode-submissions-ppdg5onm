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
    public ListNode reverse(ListNode l1){
        ListNode prev = null;
        ListNode curr = l1;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode l3 = new ListNode(-1);
        ListNode curr = l3;
        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }

        // return reverse(l3.next);
        return l3.next;
    }
}
