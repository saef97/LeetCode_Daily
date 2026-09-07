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
    int dfs(TreeNode node){
        if(node == null)return 0;
        int left = Math.max(0,dfs(node.left));
        int right = Math.max(0,dfs(node.right));//hum basically negative wale brahc ko prune lkar rhe hai..
        int sum = left+right+node.val;
        max = Math.max(sum,max);
        return node.val+ Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root == null)return 0;
        dfs(root);
        return max;
    }
}