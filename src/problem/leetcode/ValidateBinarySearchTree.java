package problem.leetcode;

//98
public class ValidateBinarySearchTree {

    private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode node, long lowerBound, long upperBound) {
        if(node == null) {
            return true;
        }
        if(node.val > lowerBound && node.val < upperBound) {
            return isValidBSTUtil(node.left, lowerBound, node.val) && isValidBSTUtil(node.right, node.val, upperBound);
        }
        return false;
    }
}
