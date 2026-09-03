class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0 && num < minOdd) {
                minOdd = num;
            }
        }

        // If there are no odd numbers, all elements are already even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // If the smallest element in the entire array is odd, we can make all elements odd
        if (minVal % 2 != 0) {
            return true;
        }

        // Otherwise (minVal is even and there is at least one odd), impossible
        return false;
    }
}