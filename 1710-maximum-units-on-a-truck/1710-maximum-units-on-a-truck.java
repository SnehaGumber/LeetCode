class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;

        Arrays.sort(boxTypes, (a,b) ->  Integer.compare(b[1], a[1]));

        int units = 0;
        int remaining = truckSize;
        
        for(int i=0; i<n; i++){
            int take = Math.min(boxTypes[i][0], remaining);
            units += take * boxTypes[i][1];
            remaining -= take;
            if(remaining == 0) break;
        }

        return units;
    }
}