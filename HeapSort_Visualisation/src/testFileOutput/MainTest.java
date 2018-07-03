package testFileOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static testFileOutput.HeapSort.printArray;

public class MainTest {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:/Users/Sergey/IdeaProjects/HeapSort_Visualisation/resource/input.dat"));
        FileReadArray f = FileReadArray.init(in);

        HeapSort ob = new HeapSort(f.getArray());
        ob.sort(f.getArray());

        printArray(ob.getSortArr());
    }
}
