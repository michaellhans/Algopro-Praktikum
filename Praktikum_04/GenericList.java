// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 24 September 2021
// Topik    : Latihan Praktikum 4 Soal 1
// Deskripsi: Generic Array

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericList<T extends Comparable<T>> {
    private ArrayList<T> arr;

    // Default constructor for Generic Tree
    public GenericList() {
        this.arr = new ArrayList<T>();
    }

    public void addElement(T element) {
        arr.add(element);
    }

    public void printSortedList() {
        List<T> sortedArr = new ArrayList<T>(arr);
        Collections.sort(sortedArr);
        System.out.println(sortedArr);
    }

    public void printReversedList() {
        List<T> reversedArr = new ArrayList<T>(arr);
        Collections.reverse(reversedArr);
        System.out.println(reversedArr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println("Array kosong");
        } else {
            if (choice == 1) {
                GenericList<Integer> genArr = new GenericList<Integer>();
                for (int i = 0; i < N; i++) {
                    int value = sc.nextInt();
                    genArr.addElement(value);
                }
                genArr.printReversedList();
                genArr.printSortedList();

            } else if (choice == 2) {
                GenericList<Character> genArr = new GenericList<Character>();
                for (int i = 0; i < N; i++) {
                    char value = sc.next().charAt(0);
                    genArr.addElement(value);
                }
                genArr.printReversedList();
                genArr.printSortedList();

            } else {
                GenericList<String> genArr = new GenericList<String>();
                for (int i = 0; i < N; i++) {
                    String value = sc.next();
                    genArr.addElement(value);
                }
                genArr.printReversedList();
                genArr.printSortedList();
            }
        }

        sc.close();
    }
}