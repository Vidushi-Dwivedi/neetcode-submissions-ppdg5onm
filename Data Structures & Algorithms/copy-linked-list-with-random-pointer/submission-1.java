/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node l2 = new Node(-1);
        Map<Node, Node> map = new HashMap<>();

        Node c1 = head;
        Node c2 = l2;

        while(c1 != null){
            c2.next = new Node(c1.val);
            c2 = c2.next;
            map.put(c1, c2);
            c1 = c1.next;
        }

        c1 = head;
        c2 = l2.next;

        while(c1 != null){
            if(c1.random == null){
                c2.random = null;
            } else{
                Node key = c1.random;
                c2.random = map.get(key);
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        return l2.next;
    }
}
