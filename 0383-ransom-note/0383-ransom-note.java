class Solution {
    public boolean canConstruct(String r, String m) {
        int w=r.length();
        int y=m.length();
        int freq[] = new int[26];
        for(int i=0;i<y;i++){
            char ch=m.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<w;i++){
            char ch=r.charAt(i);
            freq[ch-'a']--;
        }
        for(int i=0;i<r.length();i++){
            if(freq[r.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}