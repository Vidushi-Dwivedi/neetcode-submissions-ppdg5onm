class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        // Step 1: Initialize a tracking matrix for the minimum time to reach each cell
        int[][] timeToReach = new int[n][n];
        for (int[] row : timeToReach) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        timeToReach[0][0] = grid[0][0];
        
        // Step 2: Min-Heap stores arrays of shape {row, col, max_elevation_so_far}
        // Sorted by the max elevation encountered on the path
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        
        // Direction vectors for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Step 3: Process the grid greedily
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];
            
            // If we reached the destination, this is our optimal minimum time
            if (r == n - 1 && c == n - 1) {
                return t;
            }
            
            // Skip if we found a route that provides a worse time to this node
            if (t > timeToReach[r][c]) {
                continue;
            }
            
            // Explore all 4 neighbors
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Grid boundary check
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    // The time needed to step into the neighbor is the maximum of
                    // the time accumulated so far and the neighbor's own elevation
                    int nextTime = Math.max(t, grid[nr][nc]);
                    
                    // If this route is faster than any previously recorded path to (nr, nc)
                    if (nextTime < timeToReach[nr][nc]) {
                        timeToReach[nr][nc] = nextTime;
                        pq.offer(new int[]{nr, nc, nextTime});
                    }
                }
            }
        }
        
        return -1;
    }
}
