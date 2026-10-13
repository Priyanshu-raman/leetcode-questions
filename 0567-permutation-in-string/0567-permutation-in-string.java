class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Count frequencies for s1 and the first window of s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Slide the window across s2
        for (int i = 0; i < len2 - len1; i++) {
            if (matches(s1Count, s2Count)) {
                return true;
            }
            // Add the next character in the window and remove the old one
            s2Count[s2.charAt(i + len1) - 'a']++;
            s2Count[s2.charAt(i) - 'a']--;
        }
        
        // Check the last window
        return matches(s1Count, s2Count);
    }
    
    // Helper method to check if two frequency arrays are identical
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}