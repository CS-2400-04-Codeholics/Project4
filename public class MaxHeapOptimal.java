public class MaxHeapOptimal
{
private int[] Heap;
private int size;
private int maxsize;
private int swapCount;

private static final int FRONT = 1;

public MaxHeap(int maxsize)
{
this.maxsize = maxsize;
this.size = 0;
Heap = new int[this.maxsize + 1];
Heap[0] = Integer.MAX_VALUE;
swapCount = 0;
}

private int parent(int pos)
{
return pos / 2;
}

private int leftChild(int pos)
{
return (2 * pos);
}

private int rightChild(int pos)
{
return (2 * pos) + 1;
}

private boolean isLeaf(int pos)
{
if (pos >= (size / 2) && pos <= size)
{
return true;
}
return false;
}

private void swap(int fpos,int spos)
{
int tmp;
tmp = Heap[fpos];
Heap[fpos] = Heap[spos];
Heap[spos] = tmp;
swapCount++;
}

private void maxHeapify(int pos)
{
if (!isLeaf(pos))
{
if ( Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)])
{
if (Heap[leftChild(pos)] > Heap[rightChild(pos)])
{
swap(pos, leftChild(pos));
maxHeapify(leftChild(pos));
}else
{
swap(pos, rightChild(pos));
maxHeapify(rightChild(pos));
                }
            }
        }
    }

public void insert(int element)
{
int c=0;
for(int i=0;i<Heap.length;i++){
if(Heap[i]==element)
c=1;
}
if(c==1){
System.out.println("Duplicate item found,can't insert into heap");
return;
}
Heap[++size] = element;
int current = size;

while(Heap[current] > Heap[parent(current)])
{
swap(current,parent(current));
current = parent(current);
}
maxHeap();
}

public void print()
{
for (int i = 1; i <= size / 2; i++ )
{
System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
System.out.println();
}
}

public void maxHeap()
{
for (int pos = (size / 2); pos >= 1; pos--)
{
maxHeapify(pos);
}
}

public int remove()
{
int popped = Heap[FRONT];
Heap[FRONT] = Heap[size--];
maxHeapify(FRONT);
return popped;
}