class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int count1 = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count1++;
            }

            // Once we have k ones, minimize the left boundary
            while (count1 == k) {
                // Remove leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Update best answer
                if (ans.isEmpty() || current.length() < ans.length() || 
                   (current.length() == ans.length() && current.compareTo(ans) < 0)) {
                    ans = current;
                }

                // Move left pointer past the first '1' to search for next window
                left++;
                count1--;
            }
        }

        return ans;
    }
}