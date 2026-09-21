// class Solution {
//     public int SCSS(int i, int j, int[][] dp, String str1, String str2){
//         int n1 = str1.length();
//         int n2 = str2.length();
//         if(i == n1) dp[i][j] = n2-j;
//         if(j == n2) dp[i][j] = n1-i;
//         if(dp[i][j] != -1) return dp[i][j];
//         if(str1.charAt(i) == str2.charAt(j)){
//             dp[i][j] = 1+ SCSS(i+1, j+1, dp, str1, str2);
//         }
//         else{
//             int first = 1 + SCSS(i+1, j, dp, str1, str2);
//             int second = 1 + SCSS(i, j+1, dp, str1, str2);
//             dp[i][j] = Math.min(first, second);
//         }
//         return dp[i][j];
//     }
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int[][] dp = new int[str1.length()+1][str2.length()+1];
//         for(int i=0; i<str1.length(); i++) Arrays.fill(dp[i], -1);
//         SCSS(0, 0, dp, str1, str2);
//         StringBuilder sb = new StringBuilder();
//         int i=0;
//         int j=0;
//         while(i<str1.length() && j<str2.length()){
//             if(str1.charAt(i) == str2.charAt(j)){
//                 sb.append(str1.charAt(i));
//                 i++;
//                 j++;
//             }else{
//                 if(dp[i+1][j] < dp[i][j+1]){
//                     sb.append(str1.charAt(i));
//                     i++;
//                 }else{
//                     sb.append(str2.charAt(j));
//                     j++;
//                 }
//             }
//         }
//         while(i<str1.length()){
//             sb.append(str1.charAt(i));
//             i++;
//         }
//         while(j < str2.length()){
//             sb.append(str2.charAt(j));
//             j++;
//         }
//         return sb.toString();
//     }
// }









class Solution{
    public String shortestCommonSupersequence(String str1, String str2){
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int j=0; j<=n2; j++) dp[n1][j] = n2-j;
        for(int i=0; i<=n1; i++) dp[i][n2] = n1-i;
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                if(str1.charAt(i) == str2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else{
                    int first = 1 + dp[i+1][j];
                    int second = 1 + dp[i][j+1];
                    dp[i][j] = Math.min(first, second);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j = 0;
        while(i<n1 && j<n2){
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
                i++; j++;
            }
            else{
                if(dp[i+1][j] < dp[i][j+1]){
                    sb.append(str1.charAt(i));
                    i++;
                }else{
                    sb.append(str2.charAt(j));
                    j++;
                }
            }
        }
        while(i < n1){
            sb.append(str1.charAt(i));
            i++;
        }
        while(j < n2){
            sb.append(str2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}