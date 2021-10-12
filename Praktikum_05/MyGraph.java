// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 1 Oktober 2021
// Topik    : Praktikum 5 Soal 2
// Deskripsi: Design Directed Graph

import java.lang.reflect.Array;

class Edge<T> {
    T node1;
    T node2;

    // constructor
    public Edge(T node1, T node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    // setter dan getter
    public void setNode1(T node1) {
        this.node1 = node1;
    }

    public void setNode2(T node2) {
        this.node2 = node2;
    }

    public T getNode1() {
        return this.node1;
    }

    public T getNode2() {
        return this.node2;
    }
}

class DirectedGraph<T> {
    private T[] nodes;
    private Edge<T>[] edges;
    private int nNodes = 0;
    private int nEdges = 0;

    static final int NMAX_NODES = 100;
    static final int NMAX_EDGES = 200;

    // Parameter clazz diperlukan karena java tidak mendukung
    // inisiasi array of generic.
    // Contoh intansiasi (graph of integer):
    // DirectedGraph<Integer> graph = new DirectedGraph(Integer.class)

    public DirectedGraph(Class clazz) {
        nodes = (T[]) Array.newInstance(clazz, NMAX_NODES);
        edges = new Edge[NMAX_EDGES];
    }

    public void addNode(T node) {
        if (findNode(node) == null) {
            this.nodes[nNodes] = node;
            this.nNodes++;
        }
    }

    public void addEdge(T node1, T node2) {
        this.edges[nEdges] = new Edge<T>(node1, node2);
        this.nEdges++;
    }

    public void printAllNodes() {
        for (int i = 0; i < nNodes; i++) {
            System.out.println(nodes[i]);
        }
    }

    public void printAllEdges() {
        for (int i = 0; i < nEdges; i++) {
            T node1 = edges[i].getNode1();
            T node2 = edges[i].getNode2();
            System.out.println(node1 + " -> " + node2);
        }
    }

    public int calculateOutdegree(T node) {
        T selected_node = findNode(node);
        int count = 0;
        if (selected_node != null) {
            for (int i = 0; i < nEdges; i++) {
                if (edges[i].getNode1().equals(node)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int calculateIndegree(T node) {
        T selected_node = findNode(node);
        int count = 0;
        if (selected_node != null) {
            for (int i = 0; i < nEdges; i++) {
                if (edges[i].getNode2().equals(node)) {
                    count++;
                }
            }
        }
        return count;
    }

    public T findNode(T node) {
        for (int i = 0; i < nNodes; i++) {
            if (nodes[i].equals(node)) {
                return nodes[i];
            }
        }
        return null;
    }

}

public class MyGraph {

}
