/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    public Node build(int[][] grid, int i, int j, int size){
        if(size == 1){
            return new Node(grid[i][j] == 1, true);
        }
        int half = size / 2;

        Node tl = build(grid, i, j, half);
        Node tr = build(grid, i, j + half, half);
        Node bl = build(grid, i + half, j, half);
        Node br = build(grid, i + half, j+ half, half);

        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
            && tl.val == tr.val && tr.val == bl.val && bl.val == br.val){
                return new Node(tl.val, true);
            }
        
        Node newNode = new Node(true, false);
        newNode.topLeft = tl;
        newNode.topRight= tr;
        newNode.bottomLeft = bl;
        newNode.bottomRight = br;

        return newNode;
    }
}