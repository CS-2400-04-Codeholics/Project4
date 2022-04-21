import java.io.*;

public class MaxHeapDriver
{
    public static void main(String[] args) throws IOException
    {
        File outputFile = new File("data_output.txt");
        PrintStream stream = new PrintStream(outputFile);
        System.out.println("Check 'data_output.txt' to see results.");
        System.setOut(stream);

        File randomInputS = new File("data_random.txt");	
		FileReader randomfrS = new FileReader(randomInputS);
		try (BufferedReader randombrS = new BufferedReader(randomfrS)) {
            MaxHeapSequential<String> heap1 = new MaxHeapSequential<>();
            String line1;
            System.out.println("Random:");
            while((line1 = randombrS.readLine()) != null)
            {
                heap1.add(line1);
            }
            System.out.print("Heap built using sequential insertions: ");
            heap1.printMax();
            System.out.print("Number of swaps in the heap creation: ");
            heap1.printSwaps();
            for(int i = 0; i < 10; i++)
            {
                heap1.removeMax();
            }
            System.out.print("Heap after 10 removals: ");
            heap1.printMax();
        }

        File randomInputO = new File("data_random.txt");	
		FileReader randomfrO = new FileReader(randomInputO);
		try (BufferedReader randombrO = new BufferedReader(randomfrO)) {
            MaxHeapOptimal<String> heap2 = new MaxHeapOptimal<>();
            String line2;
            while((line2 = randombrO.readLine()) != null)
            {
                heap2.add(line2);
            }
            heap2.optimal();
            System.out.print("\nHeap built using optimal insertions: ");
            heap2.printMax();
            System.out.print("Number of swaps in the heap creation: ");
            heap2.printSwaps();
            for(int i = 0; i < 10; i++)
            {
                heap2.removeMax();
            }
            System.out.print("Heap after 10 removals: ");
            heap2.printMax();
        }

        File sortedInputS = new File("data_sorted.txt");	
		FileReader sortedfrS = new FileReader(sortedInputS);
		try (BufferedReader sortedbrS = new BufferedReader(sortedfrS)) {
            MaxHeapSequential<String> heap3 = new MaxHeapSequential<>();
            String line3;
            System.out.println("\nSorted:");
            while((line3 = sortedbrS.readLine()) != null)
            {
                heap3.add(line3);
            }
            System.out.print("Heap built using sequential insertions: ");
            heap3.printMax();
            System.out.print("Number of swaps in the heap creation: ");
            heap3.printSwaps();
            for(int i = 0; i < 10; i++)
            {
                heap3.removeMax();
            }
            System.out.print("Heap after 10 removals: ");
            heap3.printMax();

        File sortedInputO = new File("data_sorted.txt");	
        FileReader sortedfrO = new FileReader(sortedInputO);
        try (BufferedReader sortedbrO = new BufferedReader(sortedfrO)) {
            MaxHeapOptimal<String> heap4 = new MaxHeapOptimal<>();
            String line4;
            while((line4 = sortedbrO.readLine()) != null)
            {
                heap4.add(line4);
            }
            heap4.optimal();
            System.out.print("\nHeap built using optimal insertions: ");
            heap4.printMax();
            System.out.print("Number of swaps in the heap creation: ");
            heap4.printSwaps();
            for(int i = 0; i < 10; i++)
            {
                heap4.removeMax();
            }
            System.out.print("Heap after 10 removals: ");
            heap4.printMax();
            }
        }
    }
}