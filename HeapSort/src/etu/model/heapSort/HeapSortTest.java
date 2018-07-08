package etu.model.heapSort;

import etu.model.FileReadArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HeapSortTest {
    private HeapSort heapSort;

//    public static void main(String[] args) throws Exception {
//        JUnitCore runner = new JUnitCore();
//        Result result = runner.run(HeapSortTest.class);
//        System.out.println("run tests: " + result.getRunCount());
//        System.out.println("failed tests: " + result.getFailureCount());
//        System.out.println("ignored tests: " + result.getIgnoreCount());
//        System.out.println("success: " + result.wasSuccessful());
//    }

    @BeforeEach
    public void init() {
        Scanner in = null;
        try {
            in = new Scanner(new File("resource/input.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReadArray fileArr = FileReadArray.init(in);
        heapSort = new HeapSort(fileArr.getArray());
    }

    @AfterEach
    public void tearDown() {
        heapSort = null;
    }

    @Test
    void getSortedArray() {
    }

    @Test
    void getBinArr() {
    }
}