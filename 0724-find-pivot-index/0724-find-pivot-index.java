class Solution {
    public int pivotIndex(int[] nums) {
        int tsum=0;
        int lsum=0;
        for(int num:nums){
            tsum+=num;
        }
        for(int i=0;i<nums.length;i++){
            int rsum = tsum-nums[i]-lsum;
            if(lsum==rsum) return i;
            lsum = lsum+nums[i];
        }
        return -1;
    }
}