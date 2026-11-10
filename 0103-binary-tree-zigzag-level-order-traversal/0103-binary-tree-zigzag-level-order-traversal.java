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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> level = new LinkedList<>();
            while(size > 0){
                TreeNode curr = q.poll();
                if(leftToRight){
                    level.addLast(curr.val);
                }else{
                    level.addFirst(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                size--;
            }
            ans.add(new ArrayList<>(level));
            leftToRight = !leftToRight;
        }
        return ans;
    }
}