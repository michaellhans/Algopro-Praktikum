// NIM          : 13518056
// Nama         : Michael Hans
// Tanggal      : Jumat, 8 Oktober 2021
// Topik        : Praktikum 6
// Deskripsi    : Binary Search Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree {
    private int value;
    private BinarySearchTree leftChild;
    private BinarySearchTree rightChild;

    public BinarySearchTree(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(BinarySearchTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinarySearchTree rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return this.value;
    }

    public BinarySearchTree getLeftChild() {
        return this.leftChild;
    }

    public BinarySearchTree getRightChild() {
        return this.rightChild;
    }

    public void addChild(int new_value) {
        if (new_value > this.value) {
            if (rightChild == null) {
                this.setRightChild(new BinarySearchTree(new_value));
            } else {
                this.rightChild.addChild(new_value);
            }

        } else if (new_value < this.value) {
            if (leftChild == null) {
                this.setLeftChild(new BinarySearchTree(new_value));
            } else {
                this.leftChild.addChild(new_value);
            }
        }
    }

    public void printRecursive(int depth, String indent_type) {
        for (int i = 0; i < depth; i++) {
            System.out.print(indent_type);
        }
        System.out.println(this.value);
        if (this.leftChild != null) {
            this.leftChild.printRecursive(depth + 1, indent_type);
        }

        if (this.rightChild != null) {
            this.rightChild.printRecursive(depth + 1, indent_type);
        }
    }

    public void print(String indent_type) {
        this.printRecursive(0, indent_type);
    }

    public boolean isLeaf() {
        return ((this.leftChild == null) && (this.rightChild == null));
    }

    public BinarySearchTree search(int value) {
        BinarySearchTree node = null;
        if (this.value == value) {
            return this;

        } else {
            if (this.leftChild != null) {
                node = leftChild.search(value);
                if (node != null) {
                    return node;
                }
            }

            if (this.rightChild != null) {
                node = rightChild.search(value);
                if (node != null) {
                    return node;
                }
            }

            return null;
        }
    }

    public ArrayList<Integer> getPath(int value) {
        ArrayList<Integer> result = new ArrayList<>();
        if (search(value) != null) {
            if (this.value == value) {
                result.add(this.value);

            } else if (!isLeaf()) {
                result.add(this.value);
                BinarySearchTree branch = null;
                BinarySearchTree node = null;

                if (this.leftChild != null) {
                    node = leftChild.search(value);
                    if (node != null) {
                        branch = leftChild;
                        result.addAll(branch.getPath(value));
                    }
                }

                if (this.rightChild != null) {
                    node = rightChild.search(value);
                    if (node != null) {
                        branch = rightChild;
                        result.addAll(branch.getPath(value));
                    }
                }
            }
        }
        return result;
    }

    public static int LCA(BinarySearchTree BST, int v1, int v2) {
        ArrayList<Integer> path_to_v1 = BST.getPath(v1);
        ArrayList<Integer> path_to_v2 = BST.getPath(v2);
        int lca_value = BST.getValue();
        if (path_to_v1.size() < path_to_v2.size()) {
            Collections.reverse(path_to_v1);
            for (Integer element : path_to_v1) {
                if (path_to_v2.contains(element)) {
                    return element;
                }
            }
        } else {
            Collections.reverse(path_to_v2);
            for (Integer element : path_to_v2) {
                if (path_to_v1.contains(element)) {
                    return element;
                }
            }
        }
        return lca_value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value = sc.nextInt();
        BinarySearchTree BST = new BinarySearchTree(value);

        for (int i = 1; i < N; i++) {
            value = sc.nextInt();
            BST.addChild(value);
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        // BST.print(" ");
        System.out.println("[" + LCA(BST, v1, v2) + "]");
        sc.close();
    }
}
