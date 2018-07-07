package etu.model;

import java.util.Scanner;

public class FileReadArray {
    private final int[] arr;

    private FileReadArray(int[] arr) {
        this.arr = arr;
    }

    public static FileReadArray init(Scanner input) {
        int length = input.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = input.nextInt();
        }
        return new FileReadArray(arr);
    }

    public int[] getArray(){
        return arr;
    }
}
