class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        // 1. Collect coordinates of 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) ones1.add(new int[]{r, c});
                if (img2[r][c] == 1) ones2.add(new int[]{r, c});
            }
        }
        
        if (ones1.isEmpty() || ones2.isEmpty()) return 0;
        
        // 2. Count translation vector frequencies
        // Since -n < dr, dc < n, we can encode (dr, dc) into an integer: (dr + 100) * 200 + (dc + 100)
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;
        
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];
                int key = (dr + 100) * 200 + (dc + 100);
                
                int count = countMap.getOrDefault(key, 0) + 1;
                countMap.put(key, count);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        
        return maxOverlap;
    }
}