// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Kamis, 14 Oktober 2021
// Topik    : Latihan Praktikum 06 No 1
// Deskripsi: Binary Search Tree, Lowest Ancestor

import java.util.*;

public class BinarySearchTree {
    private int value;
    private BinarySearchTree leftNode;
    private BinarySearchTree rightNode;

    public BinarySearchTree(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void setLeftNode(BinarySearchTree leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(BinarySearchTree rightNode) {
        this.rightNode = rightNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinarySearchTree getLeftNode() {
        return leftNode;
    }

    public BinarySearchTree getRightNode() {
        return rightNode;
    }

    public int getValue() {
        return value;
    }

    public void addValue(int value) {
        if (value > this.value) {
            if (this.rightNode == null) {
                this.setRightNode(new BinarySearchTree(value));
            } else {
                this.rightNode.addValue(value);
            }
        } else if (value < this.value) {
            if (this.leftNode == null) {
                this.setLeftNode(new BinarySearchTree(value));
            } else {
                this.leftNode.addValue(value);
            }
        }
    }

    public boolean search(int value) {
        boolean found = false;
        if (this.value == value) {
            found = true;
        } else {
            if (this.leftNode != null) {
                found = this.leftNode.search(value);
            }

            if ((this.rightNode != null) && (!found)) {
                found = this.rightNode.search(value);
            }
        }
        return found;
    }

    public void printRecursive(int depth, String indent_type) {
        for (int i = 0; i < depth; i++) {
            System.out.print(indent_type);
        }

        System.out.println(this.value);
        if (this.leftNode != null) {
            this.leftNode.printRecursive(depth + 1, indent_type);
        }

        if (this.rightNode != null) {
            this.rightNode.printRecursive(depth + 1, indent_type);
        }
    }

    public void print(String indent_type) {
        this.printRecursive(0, indent_type);
    }

    public List<Integer> getPath(int value) {
        List<Integer> path = new ArrayList<>();
        if (search(value)) {
            if (this.value == value) {
                path.add(value);

            } else {
                if (this.leftNode != null) {
                    if (this.leftNode.search(value)) {
                        path.add(this.value);
                        path.addAll(this.leftNode.getPath(value));
                    }
                }

                if (this.rightNode != null) {
                    if (this.rightNode.search(value)) {
                        path.add(this.value);
                        path.addAll(this.rightNode.getPath(value));
                    }
                }
            }
        }
        return path;
    }

    public static int LCS(BinarySearchTree BST, int v1, int v2) {
        List<Integer> v1_path = BST.getPath(v1);
        List<Integer> v2_path = BST.getPath(v2);
        int lowest_ancestor = BST.getValue();

        if (v1_path.size() < v2_path.size()) {
            Collections.reverse(v1_path);
            for (Integer element : v1_path) {
                if (v2_path.contains(element)) {
                    return element;
                }
            }
        } else {
            Collections.reverse(v2_path);
            for (Integer element : v2_path) {
                if (v1_path.contains(element)) {
                    return element;
                }
            }
        }

        return lowest_ancestor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value = sc.nextInt();
        BinarySearchTree BST = new BinarySearchTree(value);

        for (int i = 1; i < N; i++) {
            value = sc.nextInt();
            BST.addValue(value);
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        System.out.println("[" + LCS(BST, v1, v2) + "]");
        sc.close();
    }

}