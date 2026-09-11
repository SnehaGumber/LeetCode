// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int gp = 0;
//         int sp = 0;
//         int count = 0;
//         while(gp!=g.length && sp!=s.length){
//             if(s[sp] >= g[gp]){
//                 count++;
//                 gp++;
//             }
//             sp++;
//         }
//         return count;
//     }
// }

class Solution{
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        int count = 0;
        while(l!=g.length && r!=s.length){
            if(g[l] <= s[r]){
                count++;
                l++;
                r++;
            }else{
                r++;
            }
        }
        return count;
    }
}





















