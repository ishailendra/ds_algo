package problem.leetcode;

import com.sun.source.tree.Tree;
import datastructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//450
public class DeleteNodeInABST {
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

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode curr = root;
        TreeNode prev = null;

        //check if the key is actually present in BST.
        //The variable prev points to the parent of the key to be deleted.
        while(curr != null && curr.val != key) {
            prev = curr;
            if(key < curr.val) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        //If key is not found
        if (curr == null) {
            return root;
        }

        //Check if the node to be deleted has atmost one child;
        if(curr.left == null || curr.right == null) {
            //newCurr will replace the node to be deleted
            TreeNode newCurr;

            //if the left child does not exist.
            if(curr.left == null) {
                newCurr = curr.right;
            }
            else {
                newCurr = curr.left;
            }

            //Check if the node to be deleted is the root
            if(prev == null) {
                return newCurr;
            }

            //Check if the node to be deleted is prev's left or right child and
            // then replace this with newCurr
            if(curr == prev.left) {
                prev.left = newCurr;
            }
            else {
                prev.right = newCurr;
            }
        }
        //node to be deleted has two children
        else {
            TreeNode p = null;
            TreeNode temp;

            //Compute the inorder successor
            temp = curr.right;
            while(temp.left != null) {
                p = temp;
                temp = temp.left;
            }
            // check if the parent of the inorder successor is the curr or not
            // (i.e curr = the node which has the same data as the given data by the user to be deleted);
            // if it isn't then make the left child of its parent equal to the inorder successor right childl
            if(p != null) {
                p.left = temp.right;
            }
            // if the inorder successor was the
            // curr (i.e. curr = the node which has the
            // same data as the given data by the
            // user to be deleted), then make the
            // right child of the node to be
            // deleted equal to the right child of
            // the inorder successor.

            else {
                curr.right = temp.right;
            }

            curr.val = temp.val;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        root = deleteNode(root, 6);

        levelOrder(root);
        
    }

    private static void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
