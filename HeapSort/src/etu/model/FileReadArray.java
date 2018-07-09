package etu.model;

import java.util.ArrayList;
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

    public static FileReadArray restore(ArrayList<Integer> buffer){
        return FileReadArray.restore(buffer); //new FileReadArray(/*Tree.restore(buffer)*//*тут передается инфа на рисовку дерева, я так понимаю*/);
    }

    public FileReadArray reedFromTextField(String text){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String i : text.split(" ")){
            list.add(Integer.parseInt(i));
        }
        return restore(list);
    }
}
