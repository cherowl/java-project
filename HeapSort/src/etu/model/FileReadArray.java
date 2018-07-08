package etu.model;

import java.util.Scanner;

public class FileReadArray {
    private final int[] arr;

    public FileReadArray(int[] arr) {
        this.arr = arr;
    }

    public static FileReadArray init(Scanner input) {
        int lenght = input.nextInt();
        int[] arr = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            if (input.hasNext()) {
                arr[i] = input.nextInt();
            }
        }
        return new FileReadArray(arr);
    }

    public int[] getArray(){
        return arr;
    }
}
