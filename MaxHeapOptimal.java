import java.util.Arrays;

public class MaxHeapOptimal<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;
    private int lastIndex;
    private boolean initialized;
    private int swaps;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeapOptimal()
    {
        this(DEFAULT_CAPACITY);
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

    private void ensureCapacity()
    {
        if(lastIndex >= heap.length -1)
        {
            int newLength = 1 + heap.length;
            checkCapacity(newLength);
            heap = Arrays.copyOf(heap, newLength);
        }
    }

    @Override
    public void add(T newEntry)
	{
		checkInitialization();
		ensureCapacity();
		heap[lastIndex + 1] = newEntry;
		lastIndex++;
	}
	
	public void optimal() 
	{
		checkInitialization();
		for(int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
			reheap(rootIndex);
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
                swaps++;
                index = largerChildIndex;
                leftChildIndex = 2 * index;
            }
            else
            {
                done = true;
            }
        }
        heap[index] = orphan;
        swaps++;
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

    public void printSwaps()
    {
        System.out.println(swaps);
    }

    public void printMax()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.print(heap[i + 1] + ",");    
        }
        System.out.println("...");
    }

}
