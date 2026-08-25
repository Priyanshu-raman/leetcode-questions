class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet set=new HashSet<>();
        for(int no:nums){
            set.add(no);
        }
        int i=1;
        while(i<=102){
            int q=k*i;
            if(!set.contains(q)){
                return q;
            }
            i++;
        }
        return 0;
    }
}