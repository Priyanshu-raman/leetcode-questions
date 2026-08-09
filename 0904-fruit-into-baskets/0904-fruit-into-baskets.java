class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitStreak = 0;
        int currentWindow = 0;
        int maxFruits = 0;

        for (int fruit : fruits) {
            // If the fruit matches either of our 2 active types
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentWindow++;
            } else {
                // New 3rd fruit type encountered:
                // Shrink window to only keep the last continuous streak + 1 current fruit
                currentWindow = lastFruitStreak + 1;
            }

            // Update streak count for the most recent fruit
            if (fruit == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            maxFruits = Math.max(maxFruits, currentWindow);
        }

        return maxFruits;
    }
}