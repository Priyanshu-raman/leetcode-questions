class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int nextGreater = -1;
            // Step 1: Find target in nums2
            int pos = 0;
            while (pos < nums2.length && nums2[pos] != target) {
                pos++;
            }
            // Step 2: Scan elements to the right of pos for the first greater value
            for (int k = pos + 1; k < nums2.length; k++) {
                if (nums2[k] > target) {
                    nextGreater = nums2[k];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }
}