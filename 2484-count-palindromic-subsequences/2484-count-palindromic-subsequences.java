
class Solution {
    public int countPalindromes(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        long[][] rightPairs = new long[10][10];
        long[] rightSingles = new long[10];

        for (int i = n - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';

            for (int a = 0; a < 10; a++) {
                rightPairs[d][a] += rightSingles[a];
            }
            rightSingles[d]++;
        }

        long[][] leftPairs = new long[10][10];
        long[] leftSingles = new long[10];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            rightSingles[d]--;
            for (int a = 0; a < 10; a++) {
                rightPairs[d][a] -= rightSingles[a];
            }

            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    ans = (ans + leftPairs[a][b] * rightPairs[b][a]) % MOD;
                }
            }

            for (int a = 0; a < 10; a++) {
                leftPairs[a][d] += leftSingles[a];
            }
            leftSingles[d]++;
        }

        return (int) ans;
    }
}
