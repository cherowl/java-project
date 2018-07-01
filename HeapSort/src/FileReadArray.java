
import java.util.Scanner;

public class FileReadArray {
    private final int[] arr;

    private FileReadArray(int[] arr) {
        this.arr = arr;
    }

    public static FileReadArray init(Scanner input) {
        int lenght = input.nextInt();
        int[] arr = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            arr[i] = input.nextInt();
        }
        return new FileReadArray(arr);
    }

    public int[] getArray(){
        return arr;
    }
}
