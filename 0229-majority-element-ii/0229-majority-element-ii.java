class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr= new ArrayList<>();
        int w=nums.length/3;
        for(int i=0;i<nums.length;i++){
            int c=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    c++;
                }
            }
            if(c>w && !arr.contains(nums[i])){
                arr.add(nums[i]);
            }
        }
        return arr;
    }
}
