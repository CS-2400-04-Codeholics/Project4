import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MaxHeapDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file1 = new File("src/data_sorted.txt");
        Scanner inputFile1 = new Scanner(file1);
        File file2 = new File("src/data_random.txt");
        Scanner inputFile2 = new Scanner(file2);

        File outputFile = new File("data_output.txt");
        PrintStream stream = new PrintStream(outputFile);
        System.setOut(stream);

        int[] array1 = new int[101];
        int[] array2 = new int[101];
        int i = 1;
        int j = 1;

        while (inputFile1.hasNext())
        {
            array1[i] = inputFile1.nextInt();
            i++;
        }

        while (inputFile2.hasNext())
        {
            array2[j] = inputFile2.nextInt();
            j++;
        }

        MaxHeapSequential<Integer> dataHeapSequentialSorted = new MaxHeapSequential<>(100);
        MaxHeapSequential<Integer> dataHeapSequentialRandom = new MaxHeapSequential<>(100);
        MaxHeapOptimal dataHeapOptimalSorted = new MaxHeapOptimal(array1);
        MaxHeapOptimal dataHeapOptimalRandom = new MaxHeapOptimal(array2);

        dataHeapSequentialSorted.read("src/data_sorted.txt");
        dataHeapSequentialRandom.read("src/data_random.txt");

        System.out.println("SORTED:");
        System.out.print("Heap built using sequential insertions: ");
        dataHeapSequentialSorted.printMax();
        System.out.println("Number of swaps used in the heap creation: " + dataHeapSequentialSorted.getSwaps());
        System.out.print("Heap after 10 removals: ");
        dataHeapSequentialSorted.removeMaxTen();
        dataHeapSequentialSorted.printMax();

        System.out.print("\nHeap built using optimal method: ");
        dataHeapOptimalSorted.printMax();
        System.out.println("Number of swaps used in the heap creation: " + dataHeapOptimalSorted.getSwaps());
        System.out.print("Heap after 10 removals: ");
        dataHeapOptimalSorted.removeMaxTen();
        dataHeapOptimalSorted.printMax();

        System.out.println("\n============================================================================================\n");

        System.out.println("RANDOM:");
        System.out.print("Heap built using sequential insertions: ");
        dataHeapSequentialRandom.printMax();
        System.out.println("Number of swaps used in the heap creation: " + dataHeapSequentialRandom.getSwaps());
        System.out.print("Heap after 10 removals: ");
        dataHeapSequentialRandom.removeMaxTen();
        dataHeapSequentialRandom.printMax();

        System.out.print("\nHeap built using optimal method: ");
        dataHeapOptimalRandom.printMax();
        System.out.println("Number of swaps used in the heap creation: " + dataHeapOptimalRandom.getSwaps());
        System.out.print("Heap after 10 removals: ");
        dataHeapOptimalRandom.removeMaxTen();
        dataHeapOptimalRandom.printMax();
    }
}
