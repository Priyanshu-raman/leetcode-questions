

class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count frequency of each letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        
        // Step 3: Assign pushes starting from the highest frequency
        for (int i = 0; i < 26; i++) {
            int count = freq[25 - i]; // Most frequent characters first
            if (count == 0) break;    // Stop early if no more characters
            
            int pushesPerChar = (i / 8) + 1; // 1 push for first 8, 2 for next 8, etc.
            totalPushes += count * pushesPerChar;
        }
        
        return totalPushes;
    }
}