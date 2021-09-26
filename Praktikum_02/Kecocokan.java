// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 10 September 2021
// Topik praktikum  : Perpustakaan
// Deskripsi        : Kecocokan berdasarkan Nama

import java.util.HashMap;
import java.util.Scanner;

public class Kecocokan {
    public static void main(String[] args) {
        HashMap<Character, Integer> char_score = new HashMap<Character, Integer>();
        char_score.put('z', 40);
        char_score.put('q', 40);
        char_score.put('x', 40);
        char_score.put('j', 40);
        char_score.put('k', 40);

        char_score.put('v', 35);
        char_score.put('b', 35);
        char_score.put('p', 35);
        char_score.put('y', 35);
        char_score.put('g', 35);

        char_score.put('f', 30);
        char_score.put('w', 30);
        char_score.put('m', 30);
        char_score.put('r', 30);
        char_score.put('c', 30);

        char_score.put('l', 20);
        char_score.put('d', 20);
        char_score.put('u', 20);
        char_score.put('h', 20);
        char_score.put('s', 20);

        char_score.put('n', 10);
        char_score.put('i', 10);
        char_score.put('o', 10);
        char_score.put('a', 10);
        char_score.put('t', 10);
        char_score.put('e', 10);

        // Input
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        // Char equality
        HashMap<Character, Integer> char_equality = new HashMap<Character, Integer>();
        for (char c : first.toCharArray()) {
            if (char_equality.get(c) == null) {
                char_equality.put(c, 1);
            }
        }

        for (char c : second.toCharArray()) {
            if (char_equality.get(c) != null) {
                char_equality.put(c, 2);
            }
        }

        // Check all same character
        int total_score = 0;
        for (int i = 97; i <= 122; i++) {
            char c = (char) i;
            if (char_equality.get(c) != null) {
                if (char_equality.get(c) == 2) {
                    total_score += char_score.get(c);
                }
            }
        }

        // Normalize the score if exceed the limit
        if (total_score >= 100) {
            total_score = 100;
        }

        System.out.println(total_score + "%");
        if ((total_score >= 0) && (total_score <= 40)) {
            System.out.println("Hanya angan - angan");
        } else if ((total_score >= 41) && (total_score <= 60)) {
            System.out.println("Tak ada yang tak mungkin");
        } else if ((total_score >= 61) && (total_score <= 80)) {
            System.out.println("Agak bisa diperjuangkan");
        } else {
            System.out.println("Cucok");
        }

        sc.close();
    }

}
