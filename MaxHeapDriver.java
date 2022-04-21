import java.io.*;

public class MaxHeapDriver
{
    public static void main(String[] args) throws IOException
    {
        File outputFile = new File("C:/Users/Migul/Downloads/CPP Projects and Assignments/Sophomore Year/Spring 2022/CS 2400/Projects/Project4/data_output.txt");
        PrintStream stream = new PrintStream(outputFile);
        System.out.println("Check 'data_output.txt' to see results.");
        System.setOut(stream);

        File randomInputS = new File("C:/Users/Migul/Downloads/CPP Projects and Assignments/Sophomore Year/Spring 2022/CS 2400/Projects/Project4/data_random.txt");	
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
/*
        File randomInputO = new File("C:/Users/Migul/Downloads/CPP Projects and Assignments/Sophomore Year/Spring 2022/CS 2400/Projects/Project4/data_random.txt");	
		FileReader randomfrO = new FileReader(randomInputO);
		try (BufferedReader randombrO = new BufferedReader(randomfrO)) {
            
            }
*/
        File sortedInputS = new File("C:/Users/Migul/Downloads/CPP Projects and Assignments/Sophomore Year/Spring 2022/CS 2400/Projects/Project4/data_sorted.txt");	
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
/*
        File sortedInputO = new File("C:/Users/Migul/Downloads/CPP Projects and Assignments/Sophomore Year/Spring 2022/CS 2400/Projects/Project4/data_sorted.txt");	
        FileReader sortedfrO = new FileReader(sortedInputO);
        try (BufferedReader sortedbrO = new BufferedReader(sortedfrO)) {
            
            }
*/
        }
    }
}