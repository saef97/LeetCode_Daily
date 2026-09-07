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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        //TreeNode curr = root;
        if(root == null)return res;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            
            if(curr.left != null){
                st.push(curr.left);
            }if(curr.right != null){
                st.push(curr.right);
            }
            res.add(curr.val);
        }
        Collections.reverse(res);
        return res;
    }
}