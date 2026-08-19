class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reservedRows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reservedRows.put(row, reservedRows.getOrDefault(row, 0) | (1 << col));
        }

        // Initially assume all n rows are empty (each holds 2 families)
        int totalFamilies = (n - reservedRows.size()) * 2;

        // Bitmasks for the 3 valid blocks
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);   // Seats 2, 3, 4, 5
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);  // Seats 6, 7, 8, 9
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7); // Seats 4, 5, 6, 7

        // Process only rows with reservations
        for (int mask : reservedRows.values()) {
            boolean leftValid = (mask & leftMask) == 0;
            boolean rightValid = (mask & rightMask) == 0;
            boolean middleValid = (mask & middleMask) == 0;

            if (leftValid && rightValid) {
                totalFamilies += 2;
            } else if (leftValid || rightValid || middleValid) {
                totalFamilies += 1;
            }
        }

        return totalFamilies;
    }
}