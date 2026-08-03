class Solution {
    public int removeDuplicates(int[] nums) {
    //    int c=0;
    //    int i=0;
    //    int j=0;
    //    int p=2;
    //    while(j<nums.length){
    //     if(nums[i]==nums[j]){
    //         if(p<1){
    //             j++;
    //         }
    //     }
    //     if(nums[i]==nums[j]){
    //         c++;

    //     }
    //     if(nums[i]!=nums[j]){
    //         i=j;
    //     }
    //    }
    //    return c;
    if (nums.length <= 2) {
            return nums.length;
        }
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
