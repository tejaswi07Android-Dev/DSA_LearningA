package trees.binary_tree;

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

/*
               1
              /  \
             /    \
            2      3
          /  \
         /    \
        4      5

        This is binary tree.

*/

//        System.out.print("InOrder: ");
//        printInorder(tree);
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

        System.out.println(rightView(tree));



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


    public static List<Integer> rightView(Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                Node t = q.poll();

                if(t.left != null){
                    q.add(t.left);
                }
                if (t.right != null){
                    q.add(t.right);
                }

                if(i == size -1){
                    rightView.add(t.data);
                }
            }
        }


        return rightView;
    }


}

