// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 3 September 2021
// Topik praktikum  : Hello World
// Deskripsi        : Penjumlahan tiga buah angka

import java.util.Scanner;

public class jumlah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = a + b + c;
        System.out.println(d);
        sc.close();
    }
}