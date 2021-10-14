// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Kamis, 14 Oktober 2021
// Topik    : Latihan Praktikum 06 No 2
// Deskripsi: Depth First Search

import java.util.*;

public class DFS {
    static int count;

    public static boolean isValid(int[][] mat, int N, int M, int row, int col, boolean[][] visited) {
        return ((row >= 0) && (row < N) && (col >= 0) && (col < M) && (mat[row][col] == 1) && (!visited[row][col]));
    }

    public static void DepthFirstSearch(int[][] mat, int N, int M, int row, int col, boolean[][] visited) {
        int[] rowMbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colMbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isValid(mat, N, M, row + rowMbr[k], col + colMbr[k], visited)) {
                count = count + 1;
                DepthFirstSearch(mat, N, M, row + rowMbr[k], col + colMbr[k], visited);
            }
        }
    }

    public static int getMaximumRegion(int[][] mat, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        int max_region = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((mat[i][j] == 1) && (!visited[i][j])) {
                    count = 1;
                    DepthFirstSearch(mat, N, M, i, j, visited);
                    if (count > max_region) {
                        max_region = count;
                    }
                }
            }
        }

        return max_region;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] mat = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaximumRegion(mat, N, M));

        sc.close();

    }
}
