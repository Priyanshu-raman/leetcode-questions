class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1; // -1 in two's complement has all bits set to 1
        
        for (int i = 0; i < nums.length; ++i) {
            // If the element is not in its correct sorted position
            if (i != nums[i]) {
                ans &= nums[i];
            }
        }
        
        // If the array was already sorted, ans remains -1, so return 0
        return Math.max(ans, 0);
    }
}