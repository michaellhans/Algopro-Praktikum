// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 18 September 2021
// Topik    : Latihan Praktikum 3 Soal 2
// Deskripsi: Umur Median dari Para Siswa

import java.util.Scanner;

public class Umur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        while (N <= 0) {
            N = sc.nextInt();
        }

        int[] umur = new int[N];

        for (int i = 0; i < N; i++) {
            umur[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (umur[j] > umur[j + 1]) {
                    int temp = umur[j];
                    umur[j] = umur[j + 1];
                    umur[j + 1] = temp;
                }
            }
        }

        int median = 0;
        if (N % 2 == 0) {
            median = umur[N / 2 - 1];
        } else {
            median = umur[N / 2];
        }

        int count_median = 0;

        for (int i = 0; i < N; i++) {
            if (umur[i] == median) {
                count_median++;
            }
        }

        System.out.println(median);
        System.out.println(count_median);

        sc.close();
    }
}
