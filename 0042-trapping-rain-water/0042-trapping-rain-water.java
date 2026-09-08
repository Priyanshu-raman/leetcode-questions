class Solution {
    public int trap(int[] height) {
        int c=0;
        int i=0;
        int j=height.length-1;
        int maxl=height[i];
        int maxr=height[j];
        while(i<j){
            if(height[i]<=height[j]){
                if(height[i]>maxl){
                    maxl=height[i];
                }
                else{
                    c+=maxl-height[i];
                }
                i++;
            }else{
                if(height[j]>maxr){
                    maxr=height[j];
                }else{
                    c+=maxr-height[j];
                }
                j--;
            }
        }
        return c;
    }
}