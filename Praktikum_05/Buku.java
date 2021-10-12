// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 1 Oktober 2021
// Topik    : Praktikum 5 Soal 3
// Deskripsi: Design Buku

import java.util.*;

public class Buku<T> {
    private T value;
    private List<Buku<T>> children;

    // Default constructor for Generic Buku
    public Buku(T value) {
        this.value = value;
        this.children = new ArrayList<Buku<T>>();
    }

    // Construct Generic Buku with its value and list of sub-generic Buku
    public Buku(T value, List<Buku<T>> children) {
        this.value = value;
        for (Buku<T> child : children) {
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

    public List<Buku<T>> getChildren() {
        return this.children;
    }

    // Add new value to the Buku nodes
    public Buku<T> addChild(T v) {
        Buku<T> child = new Buku<T>(v);
        this.children.add(child);
        return child;
    }

    // Add new child to the Buku nodes
    public Buku<T> addChild(Buku<T> child) {
        this.children.add(child);
        return child;
    }

    // Is the Buku is leaf or not
    public boolean isLeaf() {
        return (this.children.size() == 0);
    }

    // Start the recursive Buku to print with indentation
    public void printRecursive(int depth, String indent_type) {
        for (int i = 0; i < depth; i++) {
            System.out.print(indent_type);
        }
        System.out.println(this.value);
        for (Buku<T> node : children) {
            node.printRecursive(depth + 1, indent_type);
        }
    }

    // Print the generic Buku with indentation indent_type
    public void print(String indent_type) {
        this.printRecursive(0, indent_type);
    }

    public void printSurface(String indent_type) {
        System.out.println(this.value);
        for (Buku<T> node : children) {
            System.out.print(indent_type);
            System.out.println(node.value);
        }
    }

    public Buku<T> getChild(T value) {
        for (Buku<T> child : children) {
            if (child.getValue().equals(value)) {
                return child;
            }
        }
        return null;
    }

    public T getChapterTitle(T value) {
        for (Buku<T> child : children) {
            Buku<T> subchild = child.getChild(value);
            if (subchild != null) {
                return child.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        Buku<String> books = new Buku<String>(title);
        int x = sc.nextInt();
        sc.nextLine();
        while (x != 9) {
            if (x == 1) {
                // Memasukkan bab
                String chapter = sc.nextLine();
                books.addChild(chapter);
            } else if (x == 2) {
                // Memasukkan subbab
                String chapter = sc.nextLine();
                if (books.getChild(chapter) != null) {
                    String sub_chapter = sc.nextLine();
                    books.getChild(chapter).addChild(sub_chapter);
                } else {
                    System.out.println("Bab tidak ditemukan");
                }

            } else if (x == 3) {
                // Print seluruh buku
                books.print("    ");

            } else if (x == 4) {
                // Print seluruh subbab dari suatu bab
                String chapter = sc.nextLine();
                if (books.getChild(chapter) != null) {
                    books.getChild(chapter).print("    ");
                } else {
                    System.out.println("Bab tidak ditemukan");
                }

            } else if (x == 5) {
                // Print seluruh bab
                books.printSurface("    ");

            } else if (x == 6) {
                // Find subbab
                String sub_chapter = sc.nextLine();
                if (books.getChapterTitle(sub_chapter) != null) {
                    System.out.println("Ditemukan pada bab " + books.getChapterTitle(sub_chapter));
                } else {
                    System.out.println("Subbab tidak ditemukan");
                }
            }
            x = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Buku tersimpan");
        sc.close();
    }
}
