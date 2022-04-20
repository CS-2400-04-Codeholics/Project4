import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MaxHeapOptimal {
    private int size;
    private int[] arr;
    public Heap(){

    }
    //buidHeap method that works in optimal 
    public void buildHeap(int[] ar){
        this.size = ar.length;
        this.arr = new int[size];
        for(int i=0;i<ar.length;i++)
            this.arr[i] = ar[i];
        for(int i=(this.arr.length)/2;i>=0;i--){
            this.heapify(i);
        }
    }
    //max-heapify method
    public void heapify(int i){
        int largest = i;
        if(((2*i)+1)<size && this.arr[(2*i)+1]>this.arr[largest])
            largest = ((2*i)+1);
        if(((2*i)+2)<size && this.arr[(2*i)+2]>this.arr[largest])
            largest = ((2*i)+2);
        if(largest != i){
            int temp = this.arr[i];
            this.arr[i] = this.arr[largest];
            this.arr[largest] = temp;
            this.heapify(largest);
        }
    }
    public void insert(int num){

    }
    //method to remove max element from max-heap
    public int remove(){
        if(this.size<1)
            return -1;
        int temp = this.arr[0];
        this.arr[0] = this.arr[size-1];
        this.arr[size-1] = temp;
        size--;
        return this.arr[size];
    }
    //method to print elements of max heap in output file
    public void printHeap(String filename){
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < this.arr.length; i++)
                writer.write(this.arr[i] + "\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error while writing");
        }
    }
}
