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
    int preIndex = 0;
    TreeNode build(int s,int e,int [] preorder){
        //if(preIndex<map.size()){
        if(s>e)return null;
        int root = preorder[preIndex++];
        int rootIndex = map.get(root);
        TreeNode rootNode = new TreeNode(root);//mai to shiphikar diya tha 
        rootNode.left = build(s,rootIndex-1,preorder);
        rootNode.right = build(rootIndex+1,e,preorder);
        return rootNode;
       // }
       // return null;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0;i<n;i++){
            map.put(inorder[i],i);
        }
        if(0<n){
return build(0,n-1,preorder);
        }
        return null;
        

    }
}