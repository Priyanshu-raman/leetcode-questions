class Solution {
    public int maxProfit(int[] pr) {
        int max=0;
        int j=pr[0];
        for(int i=1;i<pr.length;i++){
            if(pr[i]<j){
                j=pr[i];
            }else{
                int pro=pr[i]-j;
                if(pro>max){
                   max=pro;
                }
            }
            
        }
        return max;
    }
}