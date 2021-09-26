// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 17 September 2021
// Topik praktikum  : Praktikum 3 Soal 2
// Deskripsi        : Median Umur Para Siswa

import java.util.Scanner;

public class Umur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N <= 0) {
            N = sc.nextInt();
        }

        int[] umurArray = new int[N];

        for (int i = 0; i < N; i++) {
            umurArray[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (umurArray[j] > umurArray[j + 1]) {
                    int temp = umurArray[j];
                    umurArray[j] = umurArray[j + 1];
                    umurArray[j + 1] = temp;
                }
            }
        }

        int median = N / 2 - 1;
        if (N % 2 == 1) {
            median++;
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (umurArray[i] == umurArray[median]) {
                count++;
            }
        }

        System.out.println(umurArray[median]);
        System.out.println(count);

        sc.close();
    }

}
