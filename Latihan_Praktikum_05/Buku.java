// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Kamis, 14 Oktober 2021
// Topik    : Latihan Praktikum 5 No 3
// Deskripsi: Struktur Data Buku

import java.util.*;

public class Buku {
    private String value;
    private List<Buku> children;

    public Buku(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Buku addChild(String v) {
        Buku child = new Buku(v);
        this.children.add(child);
        return child;
    }

    public Buku addChild(Buku child) {
        this.children.add(child);
        return child;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public void printRecursive(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(this.value);

        for (Buku child : children) {
            child.printRecursive(depth + 1);
        }
    }

    public void print() {
        this.printRecursive(0);
    }

    public void printSurface() {
        System.out.println(this.value);

        for (Buku child : children) {
            System.out.print("    ");
            System.out.println(child.getValue());
        }
    }

    public Buku findChapter(String chapter) {
        for (Buku child : children) {
            if (child.getValue().equals(chapter)) {
                return child;
            }
        }
        return null;
    }

    public Buku getChapterOfSubChapter(String subChapter) {
        for (Buku child : children) {
            for (Buku grandchild : child.children) {
                if (grandchild.getValue().equals(subChapter)) {
                    return child;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        Buku buku = new Buku(title);

        int x = sc.nextInt();
        while (x != 9) {
            sc.nextLine();
            if (x == 1) {
                String chapter = sc.nextLine();
                buku.addChild(chapter);
            } else if (x == 2) {
                String chapter = sc.nextLine();
                Buku chapterTree = buku.findChapter(chapter);
                if (chapterTree != null) {
                    String subchapter = sc.nextLine();
                    chapterTree.addChild(subchapter);
                } else {
                    System.out.println("Bab tidak ditemukan");
                }
            } else if (x == 3) {
                buku.print();
            } else if (x == 4) {
                String chapter = sc.nextLine();
                Buku chapterTree = buku.findChapter(chapter);
                if (chapterTree != null) {
                    chapterTree.print();
                } else {
                    System.out.println("Bab tidak ditemukan");
                }
            } else if (x == 5) {
                buku.printSurface();
            } else if (x == 6) {
                String subChapter = sc.nextLine();
                Buku chapterTree = buku.getChapterOfSubChapter(subChapter);
                if (chapterTree != null) {
                    System.out.println("Ditemukan pada bab " + chapterTree.getValue());
                } else {
                    System.out.println("Subbab tidak ditemukan");
                }
            }
            x = sc.nextInt();
        }
        System.out.println("Buku tersimpan");
        sc.close();
    }
}
