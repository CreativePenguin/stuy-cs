package hw;

public class Hw08 {
    public static void selectionSort(int[] data) {
        for(int i = 0; i < data.length - 1; i++) {
            swap(data, minIndex(data, i), i);
        }
    }

    private static void swap(int[] list, int i1, int i2) {
        int tmp = list[i1];
        list[i1] = list[i2];
        list[i2] = tmp;
    }

    private static int minIndex(int[] data, int index) {
        //reduce(lambda x, y : min(x, y), data, 0)
        int min = data[index];
        int val = index;
        for(int i = index; i < data.length; i++) {
            if(min > Math.min(data[i], min)) val = i;
        }
        return val;
    }

    public static void bubbleShort(int[] list) {
        final int N = list.length - 1;
        boolean isOrdered;
        for(int i = 0; i < N; i++) {
            isOrdered = true;
            for(int j = 0; j < N - i; j++) {
                if(list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                    isOrdered = false;
                }
            }
            if(isOrdered) break;
        }
    }

    public static void insertionSort(int[] list) {
        int n = list.length; 
        for (int i=1; i<n; ++i) {
            int key = list[i]; 
            int j = i-1; 
            while (j>=0 && list[j] > key) {
                list[j+1] = list[j]; 
                j = j-1; 
            } 
            list[j+1] = key; 
        } 
    } 
}
