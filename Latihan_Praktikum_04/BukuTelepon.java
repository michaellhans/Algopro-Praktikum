// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 25 September 2021
// Topik    : Latihan Praktikum 4 Soal 2
// Deskripsi: Buku Telepon

import java.util.Scanner;
import java.util.HashMap;

public class BukuTelepon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> bukuTelepon = new HashMap<String, String>();

        // Input the name and its phone number
        for (int i = 0; i < N; i++) {
            String key = sc.nextLine();
            String value = sc.nextLine();
            bukuTelepon.put(key, value);
        }

        // Query all N person
        for (int i = 0; i < N; i++) {
            String query = sc.nextLine();
            String number = bukuTelepon.get(query);
            if (number == null) {
                System.out.println("Not found");
            } else {
                System.out.println(query + "=" + number);
            }
        }

        sc.close();
    }
}