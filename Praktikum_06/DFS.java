// NIM          : 13518056
// Nama         : Michael Hans
// Tanggal      : Jumat, 8 Oktober 2021
// Topik        : Praktikum 6
// Deskripsi    : Depth First Search

import java.util.Scanner;

public class DFS {
    static int count;

    public static boolean isSafe(int[][] T, int n, int m, int row, int col, boolean[][] visited) {
        return ((row >= 0) && (row < n) && (col >= 0) && (col < m) && (T[row][col] == 1 && !visited[row][col]));
    }

    public static void DFS_Search(int[][] T, int n, int m, int row, int col, boolean[][] visited) {
        int[] row_range = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] col_range = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            if (isSafe(T, n, m, row + row_range[k], col + col_range[k], visited)) {
                count++;
                DFS_Search(T, n, m, row + row_range[k], col + col_range[k], visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] T = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                T[i][j] = sc.nextInt();
            }
        }

        int max_region = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((T[i][j] == 1) && (!visited[i][j])) {
                    count = 1;
                    DFS_Search(T, n, m, i, j, visited);
                    if (count > max_region) {
                        max_region = count;
                    }
                }
            }
        }

        System.out.println(max_region);
        sc.close();
    }
}
