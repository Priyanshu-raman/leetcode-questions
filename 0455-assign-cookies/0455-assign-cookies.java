class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length<1 || s.length<1) return 0;
        int c=0;
        Arrays.sort(s);
        Arrays.sort(g);
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            if(g[i]==s[j]){
                i++;
                c++;
                j++;
            }
            else if(g[i]>s[j]){
                j++;
            }
            else{
                i++;
                j++;
                c++;
            }
        }
        return c;
    }
}