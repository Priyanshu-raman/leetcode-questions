class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int max1=0;
        while(!processorTime.isEmpty()){
            int max=0;
            int i=0;
            while(i<4 && !tasks.isEmpty()){
                int p= processorTime.get(0)+tasks.get(tasks.size()-1);
                max=Math.max(max,p);
                tasks.remove(tasks.size()-1);
                i++;
            }
            max1=Math.max(max1,max);
            processorTime.remove(0);
        }
        return max1;
    }
}