class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] tallestLeft = new int[n];
        int[] tallestRight = new int[n];
        int[] water = new int[n];

        tallestLeft[0] = height[0];
        tallestRight[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            tallestLeft[i] = Math.max(tallestLeft[i-1], height[i]);
        }

        for(int i=n-2; i>=0; i--){
            tallestRight[i] = Math.max(tallestRight[i+1], height[i]);
        }

        for(int i=0; i<n; i++){
            water[i] = Math.min(tallestLeft[i], tallestRight[i]) - height[i];
        }

        int totalWater = 0;
        for(int x : water) totalWater += x;
        return totalWater;
    }
}