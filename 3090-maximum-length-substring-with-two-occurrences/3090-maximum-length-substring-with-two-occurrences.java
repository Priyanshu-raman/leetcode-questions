// class Solution {
//     public int maximumLengthSubstring(String s) {
//         // HashMap<Character,Integer> map = new HashMap<>();
//         // int i=0;
//         // int j=0;
//         // int max=0;
//         // while(j<s.length()){
//         //     int count = map.getOrDefault(s.charAt(j),0)+1;
//         //     map.put(s.charAt(j),count);
//         //     j++;
            
//         // }
//     }
// }
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;

            // Shrink window if any character appears more than twice
            while (freq[curr - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Update maximum window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}