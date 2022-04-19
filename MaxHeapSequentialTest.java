import java.io.FileNotFoundException;

public class MaxHeapSequentialTest
{
    public static void main(String[] args) throws FileNotFoundException
    {
        MaxHeapSequential<Integer> dataHeap = new MaxHeapSequential<>(100);

        dataHeap.read("src/data_sorted.txt");

        System.out.println("Max: " + dataHeap.getMax());
        System.out.println("Size: " + dataHeap.getSize());
        System.out.println("Swaps: " + dataHeap.getSwaps());
    }
}
