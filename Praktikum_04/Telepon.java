// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 24 September 2021
// Topik    : Latihan Praktikum 4 Soal 2
// Deskripsi: Buku Telepon

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Telepon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<String, String> telephone = new HashMap<String, String>();
        ArrayList<String> strInput = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String phone_number = sc.next();
            telephone.put(name, phone_number);
        }

        for (int i = 0; i < N; i++) {
            String find_name = sc.next();
            strInput.add(find_name);
        }

        for (String name : strInput) {
            if (telephone.get(name) == null) {
                System.out.println("Not found");
            } else {
                System.out.println(name + "=" + telephone.get(name));
            }
        }

        sc.close();
    }
}
