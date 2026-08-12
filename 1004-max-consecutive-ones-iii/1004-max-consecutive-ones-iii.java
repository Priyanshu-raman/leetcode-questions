 class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int max=0;
        int z=0;
        while(j<nums.length){   
            if(nums[j]==0){
                z++;
            }
            j++;
            while(z>k){
                if(nums[i]==0) z--;
                i++;
            }
            max=Math.max(max,j-i);
        }
        return max;
    }
}