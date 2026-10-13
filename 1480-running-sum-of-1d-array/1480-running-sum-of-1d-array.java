class Solution {
    public int[] runningSum(int[] nums) {
        int q[]=new int[nums.length];
        q[0]=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            q[i]=sum;
        }
        return q;
    }
}