package hw;

public final class Lab03 {

    public <N> N getParent(N[] li, int idx) {
        return li[(int) Math.ceil(idx / 2.0) / 2];
    }

    public <N> int getHeapSize(N[] li) {
        int val = 0;
        while(li.length > Math.pow(2, val)) val++;
        return val;
    }

    public <N> N getLargestNonLeafIndex(N[] li) {
        return li[(int) Math.pow(2, getHeapSize(li))];
    }

    //Question 4:
    //Max # Nodes = 2 ^ height
    //Max # Nodes on second to last level = 2 ^ height - 1

    public class BinaryHeap{

        public void print(int [] data){
            for (int x :  data)
                System.out.print(x + " ");
            System.out.println():
        }

        // pre: data != null and both i and j are index positions
        // post: the elements data[i] and data[j] are exchanged.
        public void swap(int [] data, int i, int j){
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        // Pre: data != null. data represents a binary tree
        //      that is complete up to the last level and
        //      the last level is filled from left to right
        //      up to a point.
        // Post: returns true if data has heap property
        //       false otherwise.
        public boolean isHeap(int [] data){
            return isHeapHelper(data,0);
        }

        private boolean isHeapHelper(int[] data, int i){
            isHeapHelper(data, i++);
            return getParent(data, i)
        }


        public void run() {
            int [] bheap = {5,1,3};
            print(bheap);

        }

    }

    public static void main(String[] args) {

    }

}
