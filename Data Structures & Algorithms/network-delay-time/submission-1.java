class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n+1];

        //Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
            time[i] = Integer.MAX_VALUE;
        }

        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.offer(new int[]{k ,0});
        time[k] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            for(int[] edge : adj.get(cur[0])){
                if(edge[1] + time[cur[0]] < time[edge[0]]){
                    time[edge[0]] = edge[1] + time[cur[0]];
                    pq.offer(new int[]{edge[0], time[edge[0]]});                }
            }
        }

        int max_time = -1;
        for(int i = 1;i< n+1; i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            } else if(time[i] > max_time){
                max_time = time[i];
            }
            // System.out.print(time[i] + "  ");
        }

        return max_time;
    }
}
