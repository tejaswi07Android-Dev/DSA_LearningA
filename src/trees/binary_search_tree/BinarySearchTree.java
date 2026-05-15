package trees.binary_search_tree;

import java.util.ArrayList;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] val = {5, 1, 6, 8, 7, 9};
        Node root = null;

        for (int a : val) {
            root = insert(root, a);
        }

        inOrder(root);
        System.out.println();
//        delete(root, 10);
//        inOrder(root);

//        printInRange(root, 2, 10);

//        System.out.println();

//        System.out.println(rangeSumBST(root, 2 , 7));
        pathNode2Leaf(root, new ArrayList<>());

    }

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else if (root.data < val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean search(Node root, int key) {
        if (root.data > key && root.left != null) {
            search(root.left, key);
        } else if (root.data < key && root.right != null) {
            search(root.right, key);
        } else if (root.data == key) {
            System.out.println("Found");
            return true;
        } else {
            System.out.println("Not Found");
            return false;
        }
        return false;
    }

    static Node delete(Node root, int key) {
        if (search(root, key)) {

            if (root.data > key && root.left != null) {
                root.left = delete(root.left, key);
            } else if (root.data < key && root.right != null) {
                root.right = delete(root.right, key);
            } else {
                // case 1
                if (root.left == null && root.right == null) {
                    return null;
                }

                // case 2
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }


                // case 3
                Node Is = inOrderSuccessor(root.right);
                root.data = Is.data;
                root.right = delete(root.right, Is.data);
            }
        }

        return root;

    }

    static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static void printInRange(Node root, int X, int Y){
        if(root == null) return;
        if(X <= root.data && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (X > root.data) {
            printInRange(root.right, X, Y);
        } else {
            printInRange(root.left, X, Y);
        }
    }

    static int ans = 0;

    static int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;

        if(low <= root.data && root.data <= high){
            rangeSumBST(root.left, low, high);
            ans += root.data;
            rangeSumBST(root.right, low, high);
        }else if(low > root.data){
            rangeSumBST(root.right, low, high);
        }else{
            rangeSumBST(root.left, low, high);
        }
        return ans;
    }

    static void pathNode2Leaf(Node root, ArrayList<Integer> path){
        if(root == null) return;

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            pathNode2Leaf(root.left, path);
            pathNode2Leaf(root.right, path);
        }
        path.removeLast();
    }

    static void printPath(ArrayList<Integer> path){
        for (Integer integer : path) {
            System.out.print(integer + " ->");
        }
        System.out.println();
    }
}
