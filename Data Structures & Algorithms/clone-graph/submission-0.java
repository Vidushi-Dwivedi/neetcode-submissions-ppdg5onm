/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<Node,Node>();

    public Node cloneGraph(Node node) {
        if(node == null){ return null;}

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        List<Node> lst = node.neighbors;
        List<Node> newLst = new ArrayList<Node>();

        for(int i = 0; i< lst.size(); i++){
            newLst.add(cloneGraph(lst.get(i)));
        }

        newNode.neighbors = newLst;
        
        return newNode;
    }
}