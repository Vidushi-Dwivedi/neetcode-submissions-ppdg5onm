class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            ans.add(cur);

            for(int neighbour : graph.get(cur)){
                if(--indegree[neighbour] == 0){
                    que.offer(neighbour);
                }
            }
        }

        if(ans.size() < numCourses){
            return new int[0];
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i); // Autoboxing handles Integer to int conversion
        }

        return arr;
    }
}
