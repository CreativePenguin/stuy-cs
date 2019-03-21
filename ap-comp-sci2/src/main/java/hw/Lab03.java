package hw;

public final class Lab03 {

    public Number getParent(Number[] li, int idx) {
        return li[(int) Math.ceil(idx / 2.0) - 1];
    }

    public int getHeapSize(Number[] li) {
        int val = 0;
        while(li.length > Math.pow(2, val)) val++;
        return val;
    }

    public Number getLargestNonLeafIndex(Number[] li) {
        return li[(int) Math.pow(2, getHeapSize(li))];
    }

    //Question 4:
    //Max # Nodes = 2 ^ height
    //Max # Nodes on second to last level = 2 ^ height - 1

    public class BinaryHeap{

        public void print(Number[] data){
            for (Number x :  data)
                System.out.print(x + " ");
            System.out.println();
        }

        // pre: data != null and both i and j are index positions
        // post: the elements data[i] and data[j] are exchanged.
        public void swap(Number[] data, int i, int j){
            Number temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        // Pre: data != null. data represents a binary tree
        //      that is complete up to the last level and
        //      the last level is filled from left to right
        //      up to a point.
        // Post: returns true if data has heap property
        //       false otherwise.
        public boolean isHeap(Number[] data){
            return isHeapHelper(data,data.length - 1);
        }

        private boolean isHeapHelper(Number[] data, int i) {
            if(getParent(data, i).doubleValue() < data[i].doubleValue()) {
                return false;
            }
            else if(i > 1) {
                return isHeapHelper(data, --i);
            }
            else {
                return true;
            }
        }

    }

    public static void main(String[] args) {
        Lab03.BinaryHeap l3 = new Lab03().new BinaryHeap();
        System.out.println(l3.isHeap(new Number[] {1, 2, 3, 4, 5, 6, 7}));
        System.out.println(l3.isHeap(new Number[] {7, 6, 5, 4, 3, 2, 1}));
        System.out.println(l3.isHeap(new Number[] {7, 6, 5, 4, 3, 1, 2}));
    }

}
