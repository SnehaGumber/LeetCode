class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp2 = new ArrayList<>();
        if(rowIndex == 0){
            temp2.add(1);
            return temp2;
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<=rowIndex; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<i+1; j++){
                if(j==0 || j==i) temp.add(1);
                else temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(temp);
        } 
        return ans.get(rowIndex);
    }
}