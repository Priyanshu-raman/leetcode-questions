class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<op.length;i++){
            String s=op[i];
            if(s.equals("C")) st.pop();
            else if(s.equals("D")) st.push(2*st.peek());
            else if(s.equals("+")){
                int top=st.pop();
                int topp=st.peek();
                int sum=top+topp;
                st.push(top);
                st.push(sum);
            }
            else st.push(Integer.parseInt(s));
        }
        int sum=0;
        while(st.size()>0){
            int top=st.pop();
            sum+=top;
        }
        return sum;
    }
}