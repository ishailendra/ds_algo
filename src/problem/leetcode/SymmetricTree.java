package problem.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//101
public class SymmetricTree {

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



   public static boolean isSymmetric(TreeNode root) {
       if (root == null) {
           return false;
       } else if (root.right == null && root.left == null) {
           return true;
       } else {
           return isSymmetricUtil(root.left, root.right);
       }
   }

       public static boolean isSymmetricUtil(TreeNode p, TreeNode q) {
           if (p == null && q == null) {
               return true;
           } else if (p == null || q == null) {
               return false;
           } else if (p.val != q.val) {
               return false;
           } else {
               return (isSymmetricUtil(p.left, q.right) && isSymmetricUtil(p.right, q.left));
           }
       }


       public static boolean isSymmetric2(TreeNode root) {
           if (root == null) {
               return false;
           }

           Queue<TreeNode> queue = new LinkedList<>();
           queue.offer(root);

           int count = 1;

           while(!queue.isEmpty()) {

               String str1 = "";
                String str2 = "";

               int size = queue.size();;

               for (int i = 0; i < size; i++) {
                   TreeNode curr = queue.poll();
                   if (curr == null) {
                       if(i<size/2)
                            str1 += "#";
                       else
                           str2 = "#"+str2;
                       continue;
                   }
                   if(i<size/2)
                       str1 += curr.val;
                   else
                       str2 = curr.val+str2;

                   queue.offer(curr.left);
                   queue.offer(curr.right);
               }

//               System.out.println("String generated: "+ str1+"   "+str2);

               if(!str1.equals(str2) && count != 1){
                   return false;
               }
               count++;

           }

           return true;
       }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-57);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(67);
        root.left.right.right = new TreeNode(-97);
        root.right = new TreeNode(-57);
        root.right.left = new TreeNode(67);
//        root.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(-97);
        System.out.println(isSymmetric2(root));
        System.out.println(isSymmetric(root));





        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric2(root2));
        System.out.println(isSymmetric(root2));
    }
}
