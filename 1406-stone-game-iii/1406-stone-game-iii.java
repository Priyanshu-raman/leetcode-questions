class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int next1 = 0, next2 = 0, next3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxScore = Integer.MIN_VALUE;
            
            // Pick 1 stone
            int sum = stoneValue[i];
            maxScore = Math.max(maxScore, sum - next1);

            // Pick 2 stones
            if (i + 1 < n) {
                sum += stoneValue[i + 1];
                maxScore = Math.max(maxScore, sum - next2);
            }

            // Pick 3 stones
            if (i + 2 < n) {
                sum += stoneValue[i + 2];
                maxScore = Math.max(maxScore, sum - next3);
            }

            // Shift states backward
            next3 = next2;
            next2 = next1;
            next1 = maxScore;
        }

        if (next1 > 0) return "Alice";
        if (next1 < 0) return "Bob";
        return "Tie";
    }
}