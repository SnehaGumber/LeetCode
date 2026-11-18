class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int a = st.pop();
                int b = st.pop();
                if(token.equals("+")) st.push(b+a);
                else if(token.equals("-")) st.push(b-a);
                else if(token.equals("*")) st.push(b*a);
                else st.push(b/a);
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}