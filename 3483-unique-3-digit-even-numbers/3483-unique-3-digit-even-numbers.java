class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequency of available digits (0-9)
        int[] available = new int[10];
        for (int d : digits) {
            available[d]++;
        }

        int count = 0;

        // Check all 3-digit even numbers from 100 to 998
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;         // hundreds place
            int d2 = (num / 10) % 10;   // tens place
            int d3 = num % 10;          // units place

            int[] needed = new int[10];
            needed[d1]++;
            needed[d2]++;
            needed[d3]++;

            // Verify if we have enough copies of each needed digit
            if (available[d1] >= needed[d1] &&
                available[d2] >= needed[d2] &&
                available[d3] >= needed[d3]) {
                count++;
            }
        }

        return count;
    }
}