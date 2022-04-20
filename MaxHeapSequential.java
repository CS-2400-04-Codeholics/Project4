import java.io.*;
import java.util.Scanner;

public class MaxHeapSequential<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;
    private int lastIndex;
    private boolean initialized;
    private int swaps;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeapSequential()
    {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeapSequential(int initialCapacity)
    {
        if (initialCapacity < DEFAULT_CAPACITY)
        {
            initialCapacity = DEFAULT_CAPACITY;
        }
        else
        {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempHeap =  (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
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

    @Override
    public void add(T newEntry)
    {
        checkInitialization();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
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

    public T remove(int entry)
    {
        checkInitialization();
        T node = null;
        if (!isEmpty())
        {
            node = heap[entry];
            heap[entry] = heap[lastIndex];
            lastIndex--;
            reheap(entry);
        }
        return node;
    }

    @Override
    public T removeMax()
    {
        checkInitialization();
        T root = null;
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
        T orphan = heap[index];
        int leftChildIndex = 2 * index;
        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[index] = heap[largerChildIndex];
                index = largerChildIndex;
                leftChildIndex = 2 * index;
            }
            else
            {
                done = true;
            }
        }
        heap[index] = orphan;
    }

    @Override
    public T getMax()
    {
        checkInitialization();
        T root = null;
        if (!isEmpty())
        {
            root = heap[1];
        }
        return root;
    }

    @Override
    public boolean isEmpty()
    {
        return lastIndex < 1;
    }

    @Override
    public int getSize()
    {
        return lastIndex;
    }

    @Override
    public void clear()
    {
        checkInitialization();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    public int getSwaps()
    {
        return swaps;
    }

    @SuppressWarnings("unchecked")
    public void read(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        MaxHeapSequential<Integer> intHeap = (MaxHeapSequential<Integer>) this;
        while (inputFile.hasNext())
        {
            intHeap.add(inputFile.nextInt());
        }

    }


}
