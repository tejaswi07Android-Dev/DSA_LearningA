package trees.binary_tree;

import javax.swing.*;
import java.util.*;

class BinaryTree {

    static class Node{
        int data;
        Node right;
        Node left;
    }

    public static void main(String[] args) {

        Node tree = addNewNode(1);
        tree.left = addNewNode(2);
        tree.left.left = addNewNode(4);
        tree.left.right = addNewNode(5);
        tree.right = addNewNode(3);
        tree.right.right = addNewNode(6);


        Node tree2 = addNewNode(1);
        tree2.left = addNewNode(2);
        tree2.left.left = addNewNode(4);
        tree2.left.left = addNewNode(4);
        tree2.left.right = addNewNode(5);
        tree2.right = addNewNode(3);

        Node BsTree = addNewNode(8);

        BsTree.left = addNewNode(3);
        BsTree.right = addNewNode(10);

        BsTree.left.left = addNewNode(1);
        BsTree.left.right = addNewNode(6);

        BsTree.left.right.left = addNewNode(4);
        BsTree.left.right.right = addNewNode(7);

        BsTree.right.right = addNewNode(14);
        BsTree.right.right.left = addNewNode(13);

/*                8             <---- Binary Search Tree BsTree
                /   \
               3     10
              / \      \
             1   6      14
                / \     /
               4   7   13


               1
              /  \
             /    \
            2      3
          /  \
         /    \
        4      5

        This is binary tree.

*/

        System.out.print("InOrder: ");
        printInorder(tree);
//        System.out.println();
//        System.out.print("PreOrder: ");
//        printPreorder(tree);
//        System.out.println();
//        System.out.print("PostOrder: ");
//        printPostorder(tree);
//        System.out.println();
//        System.out.print("LevelOrder: ");
//        levelOrderPrint(tree);
//        System.out.println();
//        zigZagOrderPrint(tree);
//        System.out.println();
//        simpleLevelOrderPrint(tree);

//        System.out.println(isBalanced(tree));

//        System.out.println(isSameTreee(tree, tree2));
//        System.out.println(maxDepth(tree));

        System.out.println(levelOrder(tree));

        String str = "asdc";

        char[] ch = str.toCharArray();

        Arrays.sort(ch);

        String res = new String(ch);

        System.out.println(res);



    }

    public static void printInorder(Node n) {
        if (n == null) {
            return;
        }
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);

    }

    public static void printPreorder(Node n) {
        if (n == null) {
            return;
        }

        System.out.print(n.data + " ");
        printPreorder(n.left);
        printPreorder(n.right);

    }

    public static void printPostorder(Node n) {
        if (n == null) {
            return;
        }


        printPostorder(n.left);
        printPostorder(n.right);
        System.out.print(n.data + " ");

    }

    public static void levelOrderPrint(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if (root == null) {
            System.out.println(ans);
            return;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size > 0) {
                Node temp = q.peek();
                q.remove();
                t.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                size--;
            }
            ans.add(t);
        }

        System.out.println(ans);

    }

    public static void zigZagOrderPrint(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if (root == null) {

            System.out.println(ans);
            return;
        }
        while (true) {
            int size = q.size();
            if(size == 0){
                break;
            }
            List<Integer> t = new ArrayList<>();
            while (size > 0) {
                Node temp = q.peek();
                q.remove();
                t.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                size--;
            }
            ans.add(t);
        }

        for(int i = 1; i < ans.size(); i++){
            if(i%2 == 1){
                Collections.reverse(ans.get(i));
            }
        }

        System.out.println(ans);

    }

    public static void simpleLevelOrderPrint(Node root){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()){
            Node temp = q.poll();
            ans.add(temp.data);

            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }

        System.out.println(ans);



    }

    public static Node addNewNode(int D) {
        Node temp = new Node();
        temp.data = D;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    public static boolean isBalanced(Node root){
        return height(root) != -1;
    }

    public static int height(Node node){
        if(node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(node.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) +1;
    }

    public static Node invertTree(Node root){
        if(root == null) return root;

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static boolean isMirror(Node left, Node right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return  left.data == right.data
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    public static boolean isSymmetric(Node root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isSameTreee(Node A, Node B){
        if(A == null && B == null) return true;

        if(A == null || B == null) return false;

        if(A.data != B.data) return false;

        return isSameTreee(A.left, B.left) && isSameTreee(A.right, B.right);
    }


    public static boolean isSameTree(Node A, Node B){
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        inOrderWithNull(A, first);
        inOrderWithNull(B, second);
        if(first.size() != second.size()) return false;

        for(int i = 0; i < first.size(); i++){
            if(!first.get(i).equals(second.get(i))){
                return false;
            }
        }

        return true;
    }


    public static void inOrderWithNull(Node n, ArrayList<Integer> arr) {
        if (n == null) {
            arr.add(-1);
            return;
        }

        inOrderWithNull(n.left, arr);
        arr.add(n.data);
        inOrderWithNull(n.right, arr);

    }


    int diameter = 0;

    public int diameterOfBinaryTree(Node root) {
        heights(root);
        return diameter;
    }

    private int heights(Node node) {
        if (node == null)
            return 0;

        int left = heights(node.left);
        int right = heights(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }






    ///--------------------------------------------------------------------



    public static int maxDepth(Node root){
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }

    public static boolean isValidBST(Node root){
        ArrayList<Integer> s = new ArrayList<>();
        inOrder(root, s);

        for(int i = 1; i < s.size(); i++){
            if(s.get(i) < s.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBSTN(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(Node node, long min, long max) {

        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return check(node.left, min, node.data) &&
                check(node.right, node.data, max);
    }

    public static void inOrder(Node root, ArrayList<Integer> s){
        if(root == null) return;
        inOrder(root.left, s);
        s.add(root.data);
        inOrder(root.right, s);
    }


    public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
        if(root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size > 0){
                Node t = q.poll();
                temp.add(t.data);

                if(t.left != null){
                    q.add(t.left);
                }

                if(t.right != null){
                    q.add(t.right);
                }

                size--;
            }
            ans.add(temp);
        }

        return ans;
    }


    public static boolean hasPathSum(Node root, int T){
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return root.data == T;
        }

        return hasPathSum(root.left, T - root.data) ||
                hasPathSum(root.right, T - root.data);
    }

    public static boolean isValidBSTree(Node root){
        return checkLR(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static boolean checkLR(Node root, long min, long max){
        if(root == null) return true;

        if(root.data <= min || root.data >= max) return false;

        return checkLR(root.left, min, root.data) &&
                checkLR(root.right, root.data, max);
    }

    static int count = 0;
    static int ans = -1;


    public static int kthSmallest(Node root, int k){
        count =0;
        ans = -1;
        inOrders(root, k);
        return ans;
    }

    public static void inOrders(Node root, int k){
        if(root == null) return;


        inOrders(root.left, k);
        count++;
        if(count == k){
            ans = root.data;
            return;
        }
        inOrders(root.right, k);

    }

    public static int kthLargest(Node root, int k ){
        count = 0;
        ans = -1;
        reverseOrder(root, k);
        return ans;
    }

    public static void reverseOrder(Node root, int k){
        if (root == null) return;


        reverseOrder(root.right, k);
        count++;
        if(count == k){
            ans = root.data;
            return;
        }

        reverseOrder(root.left, k);

    }







}

