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
    int max;
    int dfsGetHeight(TreeNode node){
        if(node == null)return 0;
        int left = dfsGetHeight(node.left);
        int right = dfsGetHeight(node.right);
        max = Math.max(max,right+left);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
       max = Integer.MIN_VALUE;
      // max = Math.max(max,
       dfsGetHeight(root);
       //);
        return max;
    }
}