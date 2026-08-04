class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        Set<Integer> numSet = new HashSet<>();

        // Find min, max, and populate the set in a single pass
        for (int num : nums) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
            numSet.add(num);
        }

        List<Integer> missing = new ArrayList<>();

        // Collect all missing elements in ascending order
        for (int i = minVal; i <= maxVal; i++) {
            if (!numSet.contains(i)) {
                missing.add(i);
            }
        }

        return missing;   
    }
}