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
    public TreeNode flat(TreeNode root){
        if(root==null)return null;
        TreeNode lp=flat(root.left);
        TreeNode rp=flat(root.right);
        if(lp!=null){
            TreeNode curr=lp,second=null;
            while(curr!=null){
                second=curr;
                curr=curr.right;}
            second.right=rp;
            root.right=lp;
            root.left=null;
        }
        return root;
    }
    public void flatten(TreeNode root) {
        if(root==null)return;
        TreeNode ans=flat(root);
    }
}