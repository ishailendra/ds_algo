package problem.leetcode;

import datastructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//701
public class InsertIntoABinarySearchTree {

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
    
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);


        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            if(temp.val < val) {
                if(temp.right != null) {
                    stack.push(temp.right);
                    continue;
                }else {
                    temp.right = new TreeNode(val);
                    break;
                }
            }

            if(temp.val > val) {
                if(temp.left != null) {
                    stack.push(temp.left);
                    continue;
                }else {
                    temp.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    //recursion
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode bstRoot = insertIntoBST(root, 5);
        levelOrder(bstRoot);
    }
}
