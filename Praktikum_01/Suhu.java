// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 3 September 2021
// Topik praktikum  : Hello World
// Deskripsi        : Konversi Suhu

import java.util.Scanner;

public class Suhu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        String code = sc.next();

        double value = 50;
        if (code.equals("R")) {
            value = 4 * t / 5;
        } else if (code.equals("F")) {
            value = (9 * t / 5) + 32;
        } else if (code.equals("K")) {
            value = t + 273.15;
        }

        System.out.println(String.format("%.2f", value));
        sc.close();
    }
}