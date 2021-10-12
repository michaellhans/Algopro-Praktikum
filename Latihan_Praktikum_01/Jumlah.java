// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 18 September 2021
// Topik    : Latihan Praktikum 1 - Penjumlahan
// Deskripsi: Penjumlahan Tiga Buah Angka

import java.util.Scanner;

public class Jumlah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(a + b + c);

        sc.close();
    }
}