class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        
        int minOpen = 0;
        int maxOpen = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch=='('){
                minOpen = minOpen + 1;
                maxOpen = maxOpen + 1;
            }
            else if(ch==')'){
                minOpen = minOpen - 1;
                maxOpen = maxOpen - 1;
                if(minOpen < 0) minOpen = 0;
                if(maxOpen < 0) return false;
            }else{
                minOpen = minOpen - 1;
                maxOpen = maxOpen + 1;
                if(minOpen < 0) minOpen = 0;
            }
        }
        return minOpen == 0;
    }
}