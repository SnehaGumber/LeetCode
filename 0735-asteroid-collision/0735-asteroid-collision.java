class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(arr[i]<0 && !st.isEmpty() && st.peek()>0 &&  Math.abs(arr[i])>st.peek()) st.pop();
            if(arr[i]<0 && !st.isEmpty() && st.peek() > 0 && Math.abs(arr[i])==st.peek()) st.pop();
            else if(arr[i]<0 && !st.isEmpty() && st.peek() > 0 && Math.abs(arr[i])<st.peek()) continue;
            else st.push(arr[i]);
        }
        while(!st.isEmpty()) temp.add(st.pop());
        int size = temp.size();
        int i = 0;
        int[] ans = new int[size];
        for(int j=size-1; j>=0; j--) ans[i++] = temp.get(j);
        return ans;
    }
}