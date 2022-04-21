import java.io.*;
import java.util.Scanner;

public class MaxHeapOptimal
{
    private int[] heap;
    private int lastIndex;
    private boolean initialized;
    private int swaps;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeapOptimal(int[] entries)
    {
        this(entries.length);
        lastIndex = entries.length;
        assert initialized = true;
        for (int index = 0; index < entries.length; index++)
        {
            heap[index + 1] = entries[index];
        }

        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        {
            reheap(rootIndex);
        }
    }

    public MaxHeapOptimal(int initialCapacity)
    {
        if (initialCapacity < DEFAULT_CAPACITY)
        {
            initialCapacity = DEFAULT_CAPACITY;
        }
        else
        {
            checkCapacity(initialCapacity);
        }


        heap = new int[initialCapacity + 1];
        lastIndex = 0;
        initialized = true;
    }

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Cannot have a heap exceeding " + MAX_CAPACITY + " entries.");
        }
    }

    private void checkInitialization()
    {
        if (!initialized)
        {
            throw new IllegalStateException("Heap has not initialized properly.");
        }
    }

    public void add(int newEntry)
    {
        checkInitialization();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry > heap[parentIndex])
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            swaps++;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        checkCapacity(lastIndex);
    }

    public int remove(int entry)
    {
        checkInitialization();
        int node = 0;
        if (!isEmpty())
        {
            node = heap[entry];
            heap[entry] = heap[lastIndex];
            lastIndex--;
            reheap(entry);
        }
        return node;
    }

    public int removeMax()
    {
        checkInitialization();
        int root = 0;
        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    private void reheap(int index)
    {
        boolean done = false;
        int orphan = heap[index];
        int leftChildIndex = 2 * index;
        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex] > heap[largerChildIndex])
            {
                largerChildIndex = rightChildIndex;
            }

            if (orphan < heap[largerChildIndex])
            {
                heap[index] = heap[largerChildIndex];
                index = largerChildIndex;
                leftChildIndex = 2 * index;
            }
            else
            {
                done = true;
            }
            swaps++;
        }
        heap[index] = orphan;
    }

    public int getMax()
    {
        checkInitialization();
        int root = 0;
        if (!isEmpty())
        {
            root = heap[1];
        }
        return root;
    }

    public boolean isEmpty()
    {
        return lastIndex < 1;
    }

    public int getSize()
    {
        return lastIndex;
    }

    public void clear()
    {
        checkInitialization();
        while (lastIndex > -1)
        {
            heap[lastIndex] = 0;
            lastIndex--;
        }
        lastIndex = 0;
    }

    public int getSwaps()
    {
        return swaps;
    }

    public void read(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        MaxHeapOptimal intHeap = this;
        while (inputFile.hasNext())
        {
            intHeap.add(inputFile.nextInt());
        }

    }

    public void printMax()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.print(heap[i + 1] + ",");
        }
        System.out.println("...");
    }

    public void removeMaxTen()
    {
        for (int i = 0; i < 10; i++)
        {
            this.removeMax();
        }
    }
}
