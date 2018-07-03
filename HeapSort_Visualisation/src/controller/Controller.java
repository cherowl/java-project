package src.controller;

<<<<<<< HEAD:HeapSort_Visualisation/src/controller/Controller.java
import src.heapSort.HeapSort;
import src.view.View;
=======
import etu.heapSort.FileReadArray;
import etu.heapSort.HeapSort;
import etu.view.View;
>>>>>>> d38038146ca23d5f5bd399155761b492c9b27d38:HeapSort_Visualisation/src/etu/controller/Controller.java

public class Controller {

    private final HeapSort heapSort;
    private final FileReadArray readFile;
    private final View view;

    public Controller(HeapSort heapSort, View view, FileReadArray readFile) {
        this.heapSort = heapSort;
        this.view = view;
        this.readFile = readFile;
    }

    public void viewUpdated(){
        view.draw(heapSort);
    }

    public void StartSort(){
        heapSort.sort(readFile.getArray());
        view.draw(heapSort);
    }

}
