class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int x : nums1){
            set1.add(x);
        }

        for(int i=0; i<n2; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        int size = set2.size();
        int[] res = new int[size];
        int idx = 0;
        for(int x : set2){
            res[idx++] = x;
        }

        return res;


    }
}