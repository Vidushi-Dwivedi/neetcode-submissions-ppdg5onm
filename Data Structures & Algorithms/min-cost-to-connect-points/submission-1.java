class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inTree = new boolean[n];
        int total = 0, picked = 0;

        PriorityQueue<int[]> pq = 
                    new PriorityQueue<>((a, b) -> a[1] - b[1]); //{node, edgeCost}

        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty() && picked < n){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if(inTree[node]) continue;

            inTree[node] = true;
            total += cost;
            picked++;

            for(int i = 0; i< n; i++){
                if(!inTree[i]){
                    int nextCost = Math.abs(points[i][0] - points[node][0]) +
                                        Math.abs(points[i][1] - points[node][1]);
                    pq.offer(new int[]{i, nextCost});
                }
            }
        }

        return (picked != n)? -1: total;
    }
}
