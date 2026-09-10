class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int y:nums){
            map.put(y,map.getOrDefault(y,0)+1);
        }
        for(Map.Entry<Integer,Integer> q: map.entrySet()){
            if(q.getValue()>1){
                return true;
            }
        }
        return false;
    }
}