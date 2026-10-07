class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return new int[0][0]; 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        int[][] result = new int[n][2];

        int start = intervals[0][0];
        int end = intervals[0][1];

        int idx = 0;

        for(int i=1; i<n; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                result[idx][0] = start;
                result[idx][1] = end;
                idx++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result[idx][0] = start;
        result[idx][1] = end;
        idx++;

        return Arrays.copyOf(result, idx);

    }
}