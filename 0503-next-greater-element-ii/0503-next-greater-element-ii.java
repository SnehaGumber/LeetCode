class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for(int i=2*n-1; i>=0; i--){
            int current = nums[i%n];
            while(!st.isEmpty() && st.peek()<=current)st.pop();
            if(i<n){
                if(st.isEmpty()) nge[i] = -1;
                else nge[i] = st.peek(); 
            }
            st.push(current);
        }
        return nge;
    }
}