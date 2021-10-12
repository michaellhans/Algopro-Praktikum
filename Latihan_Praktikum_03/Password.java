// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 18 September 2021
// Topik    : Latihan Praktikum 3 Soal 4
// Deskripsi: Password Generator

import java.util.Scanner;

public class Password {

    // Check if the char c is a vowel character
    static boolean isVowel(char c) {
        return ((c == 'A') || (c == 'I') || (c == 'U') || (c == 'E') || (c == 'O') || (c == 'a') || (c == 'i')
                || (c == 'u') || (c == 'e') || (c == 'o'));
    }

    // Count all vowel of array of characters
    static int countVowel(char[] text_arr) {
        int N = text_arr.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isVowel(text_arr[i])) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String text = sc.next();

            char[] text_array = text.toCharArray();
            char first_char = text_array[0];
            int vowel_count = countVowel(text_array);

            String modified_text = null;
            String extension = null;
            if (isVowel(first_char)) {
                modified_text = text;
                extension = "kuy" + vowel_count;
            } else {
                modified_text = text.substring(1);
                extension = first_char + "uy" + vowel_count;
            }

            System.out.println(modified_text + extension);

        }

        sc.close();
    }
}