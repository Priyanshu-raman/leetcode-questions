class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int c=0;
        int q=nums.length/3;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>q && !arr.contains(nums[i])){
                arr.add(nums[i]);
            }
        }
        return arr;
    }
}