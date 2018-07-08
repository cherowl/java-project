import etu.model.heapSort.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapSortTest {
    private HeapSort heapSort;

    @Test
    void getSortedArray() {
        int[] testArr = {5, 1, 3, 2, 4, 0, 6};
        heapSort = new HeapSort(testArr);
        assertTrue(heapSort.getSortedArray().length > 0);
        assertEquals(0, heapSort.getSortedArray()[0], "Cell №0");
        assertEquals(1, heapSort.getSortedArray()[1], "Cell №1");
        assertEquals(2, heapSort.getSortedArray()[2], "Cell №2");
        assertEquals(3, heapSort.getSortedArray()[3], "Cell №3");
        assertEquals(4, heapSort.getSortedArray()[4], "Cell №4");
        assertEquals(5, heapSort.getSortedArray()[5], "Cell №5");
        assertEquals(6, heapSort.getSortedArray()[6], "Cell №6");
    }

}