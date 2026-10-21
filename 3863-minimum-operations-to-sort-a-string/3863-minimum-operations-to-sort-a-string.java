class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        
        boolean isSorted = true;
        char mn = cs[0], mx = cs[0];
        
        for (int i = 1; i < n; ++i) {
            mn = (char) Math.min(mn, cs[i]);
            mx = (char) Math.max(mx, cs[i]);
            if (cs[i] < cs[i - 1]) {
                isSorted = false;
            }
        }
        
        // Case 0: Already sorted
        if (isSorted) {
            return 0;
        }
        
        // Case 1: Length 2 and not sorted is impossible
        if (n == 2) {
            return -1;
        }
        
        // Case 1 operation: min is at the start or max is at the end
        if (cs[0] == mn || cs[n - 1] == mx) {
            return 1;
        }
        
        // Case 2 operations: min or max is somewhere in the interior
        for (int i = 1; i < n - 1; ++i) {
            if (cs[i] == mn || cs[i] == mx) {
            return 2;
            }
        }
        
        // Otherwise, it takes 3 operations
        return 3;
    }
}