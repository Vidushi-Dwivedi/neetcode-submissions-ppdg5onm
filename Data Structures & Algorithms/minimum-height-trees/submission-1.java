class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        if (n == 1) {
            res.add(0);
            return res;
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int u = q.poll();
                indegree[u]--;

                for (int nei : graph.get(u)) {
                    indegree[nei]--;
                    
                    if (indegree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}