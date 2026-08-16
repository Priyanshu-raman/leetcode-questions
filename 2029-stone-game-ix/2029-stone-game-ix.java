class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }

        int c0 = count[0];
        int c1 = count[1];
        int c2 = count[2];

        // If c0 is even, 0s don't change parity
        if (c0 % 2 == 0) {
            return c1 >= 1 && c2 >= 1;
        }

        // If c0 is odd, 0s flip the game outcome
        return Math.abs(c1 - c2) > 2;
    }
}