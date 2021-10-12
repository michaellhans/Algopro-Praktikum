// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 24 September 2021
// Topik    : Latihan Praktikum 4 Soal 3
// Deskripsi: Penomoran Barang

import java.util.Scanner;
import java.util.HashMap;

public class Barang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Integer, String> lemari = new HashMap<Integer, String>();

        for (int i = 0; i < N; i++) {
            Integer number = sc.nextInt();
            String name = sc.next();
            lemari.put(number, name);
        }

        if (N == 0) {
            System.out.println("Kosong");
        } else {
            int X = sc.nextInt();
            int count = lemari.size();
            String nama_barang = lemari.get(X);
            if (nama_barang == null) {
                System.out.println("Key tidak ditemukan");
            } else {
                System.out.println(nama_barang);
            }

            System.out.println("Jumlah item pada hashmap adalah " + count);
        }

        sc.close();
    }
}
