class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charVal = 26 - (ch - 'a');
            int position = i + 1; // 1-indexed position
            
            totalSum += charVal * position;
        }
        
        return totalSum;
    }
}