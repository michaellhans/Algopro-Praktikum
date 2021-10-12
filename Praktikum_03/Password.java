// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 17 September 2021
// Topik praktikum  : Praktikum 3 Soal 4
// Deskripsi        : Pembangkitan Password

import java.util.Scanner;

public class Password {

    // Check if the character c is vocal
    static boolean isVocal(char c) {
        return ((c == 'A') || (c == 'I') || (c == 'U') || (c == 'E') || (c == 'O') || (c == 'a') || (c == 'i')
                || (c == 'u') || (c == 'e') || (c == 'o'));
    }

    // Count all vocal on char Array
    static int countVocal(char[] charArr) {
        int count = 0;
        for (char c : charArr) {
            if (isVocal(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            // Read input
            String user_input = sc.next();

            // Convert to char Array
            char[] user_input_arr = user_input.toCharArray();
            char first_char = user_input_arr[0];
            int num_vocal = countVocal(user_input_arr);

            String modified_user_input = null;
            String extension = null;
            if (!isVocal(first_char)) {
                extension = first_char + "uy" + Integer.toString(num_vocal);
                modified_user_input = user_input.substring(1);
            } else {
                extension = "kuy" + Integer.toString(num_vocal);
                modified_user_input = user_input;
            }

            // Print the output
            System.out.println(modified_user_input + extension);
        }

        sc.close();
    }
}
