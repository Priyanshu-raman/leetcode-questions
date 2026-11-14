class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};
        long[] distances = new long[6];
        int index = 0;
        
        // Calculate squared distances for all 6 pairs
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                distances[index++] = distSq(points[i], points[j]);
            }
        }
        
        // Sort the distances
        Arrays.sort(distances);
        
        // Conditions for a valid square:
        // 1. All distances must be greater than 0 (no overlapping points)
        // 2. The 4 smallest values (sides) must be equal
        // 3. The 2 largest values (diagonals) must be equal
        // 4. Diagonal squared must equal 2 * side squared
        return distances[0] > 0 &&
               distances[0] == distances[1] &&
               distances[1] == distances[2] &&
               distances[2] == distances[3] &&
               distances[4] == distances[5] &&
               distances[4] == 2 * distances[0];
    }
    
    // Helper method to compute squared Euclidean distance
    private long distSq(int[] p1, int[] p2) {
        long dx = p1[0] - p2[0];
        long dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    
    }
}