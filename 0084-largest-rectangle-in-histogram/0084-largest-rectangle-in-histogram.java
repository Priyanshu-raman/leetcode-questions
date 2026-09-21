class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int[] ps=new int[n];
        int[] ns=new int[n];
        Stack<Integer> st= new Stack<>();
        Stack<Integer> st1= new Stack<>();
        ps[0]=-1;
        st.push(0);
        ns[n-1]=n;
        st1.push(n-1);
        for(int i=1;i<n;i++){
            while(st.size()>0 && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            ps[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for(int i=n-2; i>=0;i--){
            while(st1.size()>0 && heights[i]<=heights[st1.peek()]){
                st1.pop();
            }
            ns[i] = st1.isEmpty() ? n : st1.peek();
            st1.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            int z=ns[i]-ps[i]-1;
            int area= heights[i]*z;
            max=Math.max(max,area);
        }
        return max;
    }
}