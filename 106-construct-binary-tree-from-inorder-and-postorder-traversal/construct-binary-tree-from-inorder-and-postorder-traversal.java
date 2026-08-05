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
    Map<Integer,Integer> map;
    int postIndex;
    TreeNode build(int s,int e,int[] post){
        if(s>e)return null;
        //if(postIndex>=0)
        int root = post[postIndex--];
        int rootIndex = map.get(root);
        TreeNode rootNode  = new TreeNode(root);
        
        rootNode.right = build(rootIndex+1,e,post);
        rootNode.left = build(s,rootIndex-1,post);
        return rootNode;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       int n = inorder.length;
        postIndex = n-1;
        map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(0,n-1,postorder);

    }
}