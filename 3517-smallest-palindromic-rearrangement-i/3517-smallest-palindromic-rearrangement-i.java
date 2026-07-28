class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder lef = new StringBuilder();
        char mid = 0;
        for(int i=0;i<26;i++){
            char c = (char)('a'+i);
            int count=freq[i];
            for(int k=0;k<count/2;k++){
                lef.append(c);
            }
            if(count%2!=0){
                mid =c;
            }
        }
        StringBuilder res = new StringBuilder(lef);
        if(mid!=0){
            res.append(mid);
        }
        res.append(new StringBuilder(lef).reverse());
        return res.toString();
    }
}