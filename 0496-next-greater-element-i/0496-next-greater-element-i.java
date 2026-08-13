class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        int[] nge = new int[n];
        int[] ans = new int[nums1.length];
        nge[n-1] = -1;
        st.push(nums2[n-1]);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]) st.pop();
            if(st.isEmpty()) nge[i] = -1;
            else nge[i] = st.peek();
            st.push(nums2[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums2[i], nge[i]);
        }
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}