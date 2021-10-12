// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Sabtu, 25 September 2021
// Topik    : Latihan Praktikum 4 Soal 1
// Deskripsi: Generic Array List

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class GenericList {

    // Generic Method to print reversed and sorted array
    public static <T extends Comparable<T>> void array_operation(ArrayList<T> array){
        Collections.reverse(array);
        System.out.println(array);
        Collections.sort(array);
        System.out.println(array);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<Integer> int_array = new ArrayList<Integer>();
        ArrayList<Character> char_array = new ArrayList<Character>();
        ArrayList<String> string_array = new ArrayList<String>();

        if (N == 0){
            System.out.println("Array kosong");
        } else {
            if (choice == 1){
                for (int i = 0; i < N; i++){
                    int value = sc.nextInt();
                    int_array.add(value);
                }
                array_operation(int_array);
            }
            
            else if (choice == 2){
                for (int i = 0; i < N; i++){
                    char value = sc.next().charAt(0);
                    char_array.add(value);
                }
                array_operation(char_array);
            }
            
            else {
                for (int i = 0; i < N; i++){
                    String value = sc.next();
                    string_array.add(value);
                }
                array_operation(string_array);
            }
        }

        sc.close();
    }
}