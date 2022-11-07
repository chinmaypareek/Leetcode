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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        ArrayList<Integer> level = new ArrayList<>();
        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                level.add(curr.val);
                if(curr.left != null) {
                    s2.push(curr.left);
                }
                if(curr.right != null) {
                    s2.push(curr.right);
                }
            }
            if(!level.isEmpty()) {
                result.add(new ArrayList<>(level));
            }
            level.clear();
            
            while(!s2.isEmpty()) {
                TreeNode curr = s2.pop();
                level.add(curr.val);
                if(curr.right != null) {
                    s1.push(curr.right);
                }
                if(curr.left != null) {
                    s1.push(curr.left);
                }
            }
            if(!level.isEmpty()) {
                result.add(new ArrayList<>(level));
            }
            level.clear();
        }
        return result;
    }
}