class Solution {
    public int maxProduct(int[] nums) {
        // int gmax=nums[0];
        // int cmax=1;
        // int amax=1;
        // for(int no:nums){
        //     if(no<0){
        //         int temp=cmax;
        //         cmax=amax;
        //         amax=temp;
        //     }
        //     cmax=Math.max(no,no*cmax);
        //     amax=Math.min(no,no*amax);
        //     gmax=Math.max(gmax,cmax);
        // }
        // return gmax;
        int gmax=nums[0];
        int cmax=1;
        int cmin=1;
        for(int no:nums){
            if(no<0){
                int temp=cmax;
                cmax=cmin;
                cmin=temp;
            }
            cmax=Math.max(no,no*cmax);
            cmin=Math.min(no,no*cmin);
            gmax=Math.max(gmax,cmax);
        }
        return gmax;
    }
}