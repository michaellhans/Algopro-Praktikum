// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 25 September 2021
// Topik    : Latihan Praktikum 4 Soal 3
// Deskripsi: Penomoran Barang

import java.util.Scanner;
import java.util.HashMap;

public class NomorBarang {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Integer, String> nomorBarang = new HashMap<Integer, String>();

        if (N == 0){
            System.out.println("Kosong");
        } else {
            for (int i = 0; i < N; i++){
                int key = sc.nextInt();
                String value = sc.next();
                nomorBarang.put(key, value);
            }

            int X = sc.nextInt();
            if (nomorBarang.get(X) == null){
                System.out.println("Key tidak ditemukan");
            } else {
                System.out.println(nomorBarang.get(X));
            }
            System.out.println("Jumlah item pada hashmap adalah " + nomorBarang.size());
        }

        sc.close();
    }
}