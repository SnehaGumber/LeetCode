class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for(int i=2*n-1; i>=0; i--){
            st.push(nums[i%n]);
        }
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums[i]) st.pop();
            if(!st.isEmpty() && st.peek() > nums[i]) nge[i] = st.peek();
            if(st.isEmpty()) nge[i] = -1;
            st.push(nums[i]);
        }
        return nge;
    }
}