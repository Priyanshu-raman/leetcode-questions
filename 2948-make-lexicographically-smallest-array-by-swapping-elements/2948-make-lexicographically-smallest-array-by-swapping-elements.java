class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort by values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int left = 0;

        while (left < n) {
            int right = left;

            // Find all elements belonging to the current connected group
            while (right + 1 < n && pairs[right + 1][0] - pairs[right][0] <= limit) {
                right++;
            }

            // Extract all original indices for this group
            List<Integer> indices = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                indices.add(pairs[i][1]);
            }

            // Sort indices so smaller values go to earlier positions
            Collections.sort(indices);

            // Assign sorted values to sorted indices
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = pairs[left + i][0];
            }

            left = right + 1;
        }

        return result;
    }
}