import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int c = 1; 
        int p = 1; 
        int i = 1;
        while (i < nums.length) {
            // if (nums[i] == nums[i - 1] + 1) {
            //     c++;
            // } else if (nums[i] != nums[i - 1]) {
            //     c = 1; 
            // }
            // p = Math.max(p, c); 
            // i++;
            if(nums[i]!=nums[i-1]){
                if(nums[i]==nums[i-1]+1){
                c++;
            }else{
                c=1;
            }
            }
            
            p=Math.max(p,c);
            i++;
        }
        
        return p;
    }
}