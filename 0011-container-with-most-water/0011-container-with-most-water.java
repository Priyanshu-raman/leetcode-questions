class Solution {
    public int maxArea(int[] h) {
        int i=0;
        int j=h.length-1;
        int area =0;
        int max=Integer.MIN_VALUE;
        while(i<j){
            if(h[i]<=h[j]){
                area=h[i]*(j-i);
                i++;
            }
            else{
                area=h[j]*(j-i);
                j--;
            }
            if(area>max){
                max=area;
            }
        }
        return max;
    }
}