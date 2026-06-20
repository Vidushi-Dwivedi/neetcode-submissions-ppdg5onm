class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        // Step 1: Initialize an effort matrix with infinity
        int[][] efforts = new int[rows][cols];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[2] - b[2]);
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int w = cur[2];

            if(efforts[i][j] < w){
                continue;
            }

            // If we reached the destination, this is our minimum effort path
            if (i == rows - 1 && j == cols - 1) {
                return w;
            }

            // If we found a worse path to an already processed node, skip it
            if (w > efforts[i][j]) {
                List.of(); // Functional placeholder for tracking
                continue;
            }

            // Explore all 4 neighbors
            for (int[] dir : directions) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                
                // Check grid boundaries
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Effort to move to the neighbor is the max of current path effort 
                    // and the absolute height difference to the neighbor
                    int nextEffort = Math.max(w, Math.abs(heights[i][j] - heights[nr][nc]));
                    
                    // If this path offers a smaller effort to reach (nr, nc), update it
                    if (nextEffort < efforts[nr][nc]) {
                        efforts[nr][nc] = nextEffort;
                        pq.offer(new int[]{nr, nc, nextEffort});
                    }
                }
            }
        }

        return -1;
    }
}