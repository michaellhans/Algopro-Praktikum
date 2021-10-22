import java.util.*;

// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 15 Oktober 2021
// Topik    : UTS Praktikum Tree
// Deskripsi: Implementasi Kelas Tree

public class Tree<T> {
    private T value;
    private List<Tree<T>> list_of_children;
    private Tree<T> parent;

    public Tree(T v) {
        this.value = v;
        this.list_of_children = new ArrayList<>();
        this.parent = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public List<Tree<T>> getList_of_children() {
        return list_of_children;
    }

    public Tree<T> addChild(T v) {
        Tree<T> child = new Tree<T>(v);
        child.setParent(this);
        this.list_of_children.add(child);
        return child;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.list_of_children.isEmpty();
    }

    public boolean isLastChild() {
        if (isRoot()) {
            return true;
        } else {
            List<Tree<T>> siblings = parent.getList_of_children();
            int num_siblings = siblings.size();
            return (siblings.get(num_siblings - 1).equals(this));
        }
    }

    public void print() {
        if (isRoot()) {
            System.out.print("{");
        }
        if (isLeaf()) {
            if (isLastChild()) {
                System.out.print(this.value + "}");
            } else {
                System.out.print(this.value + ",");
            }
        } else {
            System.out.print(this.value + ":{");
            for (Tree<T> child : list_of_children) {
                child.print();
            }
            if (isLastChild()) {
                System.out.print("}");
            } else {
                System.out.print(",");
            }
        }
    }

    // public static void main(String[] args) {
    // Tree<Integer> baseTree = new Tree<Integer>(2);
    // Tree<Integer> a = baseTree.addChild(7);
    // Tree<Integer> b = baseTree.addChild(5);

    // Tree<Integer> c = a.addChild(2);
    // Tree<Integer> d = a.addChild(6);

    // Tree<Integer> e = d.addChild(5);
    // Tree<Integer> f = d.addChild(11);

    // Tree<Integer> g = b.addChild(9);
    // Tree<Integer> h = g.addChild(4);

    // baseTree.print();
    // }
}
