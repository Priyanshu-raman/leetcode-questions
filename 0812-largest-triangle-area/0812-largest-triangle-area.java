class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        
        // Iterate over all possible combinations of 3 points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double currentArea = calculateArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        
        return maxArea;
    }
    
    // Helper method to calculate triangle area using the shoelace formula
    private double calculateArea(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(
            p1[0] * (p2[1] - p3[1]) + 
            p2[0] * (p3[1] - p1[1]) + 
            p3[0] * (p1[1] - p2[1])
        );
    
    }
}