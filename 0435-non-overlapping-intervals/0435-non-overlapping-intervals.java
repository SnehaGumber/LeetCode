class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int lastEnd = 0;
        int currentStart = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        lastEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            currentStart = intervals[i][0];
            if(lastEnd > currentStart){
                count++;  

            }else{
                lastEnd = intervals[i][1];
            }
            
        }
        return count;
    }
}