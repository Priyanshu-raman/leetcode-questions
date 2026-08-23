class Solution {
    public int maxProduct(int[] nums) {
        int gmax=nums[0];
        int cmax=1;
        int cmin=1;
        for(int no:nums){
            if(no<0){
                int temp=cmax;
                cmax=cmin;
                cmin=temp;
            }
            cmax=Math.max(no,cmax*no);
            cmin=Math.min(no,cmin*no);
            gmax=Math.max(gmax,cmax);
        }
        return gmax;
    }
}