class Solution {
    public String removeDuplicates(String s) {
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     int len = sb.length();
        //     if (len > 0 && sb.charAt(len - 1) == c) {
        //         sb.deleteCharAt(len - 1);
        //     } else {
        //         sb.append(c);
        //     }
        // }
        // return sb.toString();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (!st.isEmpty() && st.peek() == ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}