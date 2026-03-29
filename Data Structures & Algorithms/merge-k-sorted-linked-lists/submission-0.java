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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        if(list1==null && list2 == null){ return null;}
        else if(list1== null && list2!=null){ return list2;}
        else if(list1!= null && list2==null){ return list1;}
        else{
            ListNode curr = null;
            if(list1.val <= list2.val){
                head = list1;
                curr = head;
                list1 = list1.next;
            } else{
                head = list2;
                curr = head;
                list2 = list2.next;
            }

            while(list1!=null && list2!=null){
                if(list1.val <= list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                } else{
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            if(list1 != null){
                curr.next = list1;
            }

            if(list2 != null){
                curr.next = list2;
            }
        }

        return head;   
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode l3 = null;

        for(ListNode ll: lists){
            l3 = mergeTwoLists(l3, ll);
        }

        return l3;
    }
}
