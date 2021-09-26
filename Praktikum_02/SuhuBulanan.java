// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 10 September 2021
// Topik praktikum  : Perpustakaan (Praktikum 2B)
// Deskripsi        : Suhu Bulanan

import java.util.Scanner;

public class SuhuBulanan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] suhuArray = new int[N];

        for (int i = 0; i < N; i++) {
            suhuArray[i] = sc.nextInt();
        }

        sc.close();

        int max = -9999;
        int min = 9999;
        double sum = 0;

        int countBelowZero = 0;
        int countZero = 0;
        int countNormal = 0;
        int countHot = 0;

        if (N > 0) {
            for (int i = 0; i < N; i++) {
                if (suhuArray[i] > max) {
                    max = suhuArray[i];
                }
                if (suhuArray[i] < min) {
                    min = suhuArray[i];
                }

                if (suhuArray[i] < 0) {
                    countBelowZero++;
                } else if (suhuArray[i] == 0) {
                    countZero++;
                } else if (suhuArray[i] < 35) {
                    countNormal++;
                } else {
                    countHot++;
                }

                sum += suhuArray[i];
            }

            double mean = sum / N;

            System.out.println(max);
            System.out.println(min);
            System.out.println(String.format("%.2f", mean));
            System.out.println(countBelowZero);
            System.out.println(countZero);
            System.out.println(countNormal);
            System.out.println(countHot);
        }
    }
}
