class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        while(!st.isEmpty()){
                sb.append(st.pop());
        }
        int idx = sb.length()-1;
        while(sb.charAt(idx) == '0'){
            sb.deleteCharAt(idx);
            idx--;
            if(sb.length() == 0) return "0";
        }
        return sb.reverse().toString();
    }
}