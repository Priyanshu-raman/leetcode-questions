class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> set = new HashMap<>();
        int i=0;
        int j=0;
        int max=0;
        int freq=0;
        while(j<s.length()){
            int count = set.getOrDefault(s.charAt(j), 0) + 1;
            set.put(s.charAt(j), count);
            freq = Math.max(freq, count);
            j++;
            while(j-i-freq>k){
                set.put(s.charAt(i), set.get(s.charAt(i)) - 1);
                i++;
            }
            max=Math.max(max,j-i);
        }
        return max;
    }
}