// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 18 September 2021
// Topik    : Latihan Praktikum 1 - Suhu
// Deskripsi: Konversi Suhu

import java.util.Scanner;

public class Suhu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double T = sc.nextDouble();
        String ch = sc.next();
        double result = 0;

        if (ch.equals("K")) {
            result = 273.15 + T;
        } else if (ch.equals("R")) {
            result = 4 * T / 5;
        } else if (ch.equals("F")) {
            result = 9 * T / 5 + 32;
        }

        System.out.println(String.format("%.2f", result));
        sc.close();
    }
}