class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }
        int maxFreq = 0;
        int maxFreqCount = 0;
        for(int f : freq){
            if(f > maxFreq){
                maxFreq = f;
                maxFreqCount = 1;
            }
            else if(f == maxFreq){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length, (maxFreq-1) * (n+1) + maxFreqCount);

    }
}