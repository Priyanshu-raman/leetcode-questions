class Solution {
    public boolean canConstruct(String r, String m) {
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        for(int i=0;i<r.length();i++){
            char ch1=r.charAt(i);
            freq[ch1-'a']++;
        }
        for(int i=0;i<m.length();i++){
            char ch=m.charAt(i);
            freq1[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            freq[i]=freq[i]-freq1[i];
            if(freq[i]>0){
                return false;
            }
        }
        return true;
    }
}