class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // minLenUpTo[i] stores the minimum length of a valid subarray ending at or before index i
        int[] minLenUpTo = new int[n];
        Arrays.fill(minLenUpTo, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int ans = Integer.MAX_VALUE;
        int minLenSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink the window if currentSum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // Check if there is a valid non-overlapping subarray before 'left'
                if (left > 0 && minLenUpTo[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currentLen + minLenUpTo[left - 1]);
                }
                
                // Update minimum length seen so far up to current 'right'
                minLenSoFar = Math.min(minLenSoFar, currentLen);
            }
            
            minLenUpTo[right] = minLenSoFar;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}