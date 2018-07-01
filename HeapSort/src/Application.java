import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Application {
    // Driver program
    public static void main(String args[]) throws FileNotFoundException {
//        int arr[] = {12, 11, 13, 5, 6, 7};
//        int n = arr.length;
        File file = new File("/home/elena/workspace/java/java-project/HeapSort/resource/input.dat");
        System.err.println(file.getAbsolutePath());
        Scanner in = new Scanner(file);

        FileReadArray f = FileReadArray.init(in);


        HeapSort ob = new HeapSort();
        ob.sort(f.getArray());

        System.out.println("Sorted array is");
        ob.printArray(f.getArray());
    }
}
