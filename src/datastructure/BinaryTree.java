package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

    private Node root;

    private static class Node<E> {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
        }
    }
    //-------------------------Pre-Order Traversal: - <root><left><right>-------------------------

    //recursion
    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //iteration
    public void preOrder() {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        //Start from root node
        Node curr = this.root;

        //Run till stack is not empty or current is not null
        while(curr != null || !stack.isEmpty()) {

            while (curr != null) {
                System.out.print(curr.data + " ");
                if(curr.right != null) {
                    stack.push(curr.right);
                }

                curr = curr.left;
            }
            //We reach when curr is NULL, so we take out a right child from stack
            if(!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }

    //-------------------------In-Order Traversal: <left><root><right>-------------------------

    //recursion
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }

    //Iteration
    public void inOrder() {
        if(this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        //traverse the tree
        while(curr != null || !stack.isEmpty()) {
            //Reach the left most Node of the curr Node
            while(curr != null) {
                //Place pointer to a tree node on the stack before traversing the node's left subtree
                stack.push(curr);
                curr = curr.left;
            }

            //Current must be NULL at this point
            curr = stack.pop();

            System.out.print(curr.data);

            //we have visited the node and its left subtree.  Now, it's right subtree's turn
            curr = curr.right;
        }
    }

    //-------------------------Post-Order Traversal: <left><right><root>-------------------------
    //https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45648/three-ways-of-iterative-postorder-traversing-easy-explanation

    //recursion
    public void postOrder(Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    //iterative
    public void postOrder() {
        if(this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node<E> curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.peek();
                if(curr.right == null || curr.right == pre) {
                    System.out.print(curr.data+" ");
                    stack.pop();
                    pre = curr;
                    curr = null;
                }
                else {
                    curr = curr.right;
                }
            }
        }
        
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        //Compute height of each subtree
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }

    private void levelOrder() {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.postOrder();
        tree.postOrder(tree.root);;
        
    }
}
