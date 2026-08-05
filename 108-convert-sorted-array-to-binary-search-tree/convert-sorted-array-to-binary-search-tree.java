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
    TreeNode build(int s,int e,int[]nums){
        if(s>e)return null;
        int n = nums.length;
        int rootIndex = s + (e-s)/2;
        int root = nums[rootIndex];
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(s,rootIndex-1,nums);
        rootNode.right = build(rootIndex+1,e,nums);
        return rootNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return build(0,n-1,nums);


    }
}