class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        char p='a';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freq[ch-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]<0){
                return (char)(i+'a');
            }
        }
        return ' ';
    }
}