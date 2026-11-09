/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }
    public int findSum(TreeNode root){
        if(root == null) return 0;

        int leftGain = Math.max(0,findSum(root.left));
        int rightGain = Math.max(0, findSum(root.right));

        maxSum = Math.max(maxSum, root.val+leftGain+rightGain);

        return root.val+Math.max(leftGain, rightGain);
    }
}