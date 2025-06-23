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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        TreeNode curr=root;
        if(curr.val==val){
            return root;
        }
        if(curr.val>val){
           curr=searchBST(root.left,val);
        }
        else{
           curr= searchBST(root.right,val);
        }
        return curr;
    }
}




//  List<TreeNode> ans=new ArrayList<>();
//             Queue<TreeNode> q=new LinkedList<>();
//             while(!q.isEmpty()){
//                 TreeNode pres=q.poll();
//                 if(pres.left!=null)q.offer(pres.left);
//                 if(pres.right!=null)q.offer(pres.right);
//                 ans.add(pres);
//             }