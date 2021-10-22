import java.util.Scanner;
import java.util.Vector;

// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 15 Oktober 2021
// Topik    : UTS Praktikum Vector Integer
// Deskripsi: Implementasi Kelas Vector Integer

public class VectorInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> vector = new Vector<>();
        int Z = sc.nextInt();
        while (Z != -999) {
            vector.add(Z);
            Z = sc.nextInt();
        }
        sc.close();
        // System.out.println(vector);
    }
}
