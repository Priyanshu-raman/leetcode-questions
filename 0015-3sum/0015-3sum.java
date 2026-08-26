class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int sum =0;
        if(nums== null || nums.length <3) return result;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=nums.length-1;
            int k=i+1;
            while(k<j){
                sum =nums[i]+nums[j]+nums[k];
                if(sum ==0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k++;
                    j--;
                    while(k<j && nums[k]==nums[k-1]){
                        k++;
                    }
                    while(k<j && nums[j]==nums[j+1]){
                        j--;
                    }
                }
                else if(sum>0){
                    j--;
                }
                else k++; 
            }
        }
        return result;
    }
}