// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 1 Oktober 2021
// Topik    : Praktikum 5 Soal 1
// Deskripsi: Design Kelas Generic Tree

import java.util.*;

public class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    // Default constructor for Generic Tree
    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<Tree<T>>();
    }

    // Construct Generic Tree with its value and list of sub-generic tree
    public Tree(T value, List<Tree<T>> children) {
        this.value = value;
        for (Tree<T> child : children) {
            this.children.add(child);
        }
    }

    // Set the value of the root
    public void setValue(T value) {
        this.value = value;
    }

    // Get the root value
    public T getValue() {
        return this.value;
    }

    // Add new value to the tree nodes
    public Tree<T> addChild(T v) {
        Tree<T> child = new Tree<T>(v);
        this.children.add(child);
        return child;
    }

    // Add new child to the tree nodes
    public Tree<T> addChild(Tree<T> child) {
        this.children.add(child);
        return child;
    }

    // Is the tree is leaf or not
    public boolean isLeaf() {
        return (this.children.size() == 0);
    }

    // Print the generic tree with preorder basis 0
    public void print() {
        // Basis-0 Preorder
        if (isLeaf()) {
            System.out.print(value);
        } else {
            System.out.print(value);
            for (Tree<T> child : children) {
                System.out.print(' ');
                child.print();
            }
        }
    }

    public static void main(String[] args) {
        Tree<Integer> a = new Tree<Integer>(6);
        a.addChild(5);
        a.addChild(11);

        Tree<Integer> b = new Tree<Integer>(9);
        b.addChild(4);

        Tree<Integer> m = new Tree<Integer>(7);
        m.addChild(2);
        m.addChild(a);

        Tree<Integer> n = new Tree<Integer>(5);
        n.addChild(b);

        Tree<Integer> z = new Tree<Integer>(2);
        z.addChild(m);
        z.addChild(n);

        z.print();
    }
}
