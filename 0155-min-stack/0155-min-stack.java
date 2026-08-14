class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minSt.isEmpty()) minSt.push(value);
        else minSt.push(Math.min(value, minSt.peek()));
    }
    
    public void pop() {
        if(minSt.isEmpty()) return;
        minSt.pop();
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        else return st.peek();
    }
    
    public int getMin() {
        if(minSt.isEmpty()) return -1;
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */