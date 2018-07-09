import etu.model.heapsort.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapSortTest {
    private HeapSort heapSort;

    @Test
    void getSortedArray() {
        int[] testArr = {5, 1, 1, 2, 4, 0, 6};
        heapSort = new HeapSort(testArr);
        assertTrue(heapSort.getArray().length > 0);
        assertEquals(0, heapSort.getArray()[0], "Cell №0");
        assertEquals(1, heapSort.getArray()[1], "Cell №1");
        assertEquals(1, heapSort.getArray()[2], "Cell №2");
        assertEquals(2, heapSort.getArray()[3], "Cell №3");
        assertEquals(4, heapSort.getArray()[4], "Cell №4");
        assertEquals(5, heapSort.getArray()[5], "Cell №5");
        assertEquals(6, heapSort.getArray()[6], "Cell №6");
    }

}