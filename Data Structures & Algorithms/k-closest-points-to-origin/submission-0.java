class Solution {
    static class HeapNode{
        double dist;
        int[] point;

        HeapNode(double dist, int[] point){
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for(int[] p : points){
            double distance = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            pq.offer(new HeapNode(distance, p));

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int  i = 0;

        while(!pq.isEmpty()){
            HeapNode hp = pq.poll();
            res[i++] = hp.point;
        }

        return res;
    }
}
