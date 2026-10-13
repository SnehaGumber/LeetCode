class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for(int i=1; i<=rowIndex; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) curr.add(1);
                else{
                    curr.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = curr;
        }
        return prev;
    }
}