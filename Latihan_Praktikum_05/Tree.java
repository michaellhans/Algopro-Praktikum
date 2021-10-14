// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Kamis, 14 Oktober 2021
// Topik    : Latihan Praktikum 5 No 1
// Deskripsi: Generic Tree

import java.util.*;

public class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Tree<T> addChild(T v) {
        Tree<T> child = new Tree<T>(v);
        this.children.add(child);
        return child;
    }

    public Tree<T> addChild(Tree<T> child) {
        this.children.add(child);
        return child;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public void print() {
        if (isLeaf()) {
            System.out.print(value);
        } else {
            System.out.print(value);
            for (Tree<T> child : children) {
                System.out.print(" ");
                child.print();
            }
        }
    }
}