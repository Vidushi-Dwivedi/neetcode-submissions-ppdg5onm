class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Step 1: get topological order
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoOrder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int nei : adjList.get(node)) {
                if (--indegree[nei] == 0) queue.offer(nei);
            }
        }

        // Step 2: propagate reachability in REVERSE topo order
        // so when we process a node, all descendants are already done
        Collections.reverse(topoOrder);
        for (int node : topoOrder) {
            for (int neighbor : adjList.get(node)) {
                reachable[node][neighbor] = true;      // direct edge
                for (int k = 0; k < numCourses; k++) {
                    if (reachable[neighbor][k]) reachable[node][k] = true;
                }
            }
        }

        // Step 3: answer queries
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) ans.add(reachable[query[0]][query[1]]);
        return ans;
    }
}