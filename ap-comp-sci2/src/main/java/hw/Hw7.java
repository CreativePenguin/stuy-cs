package hw;

public class Hw7 {
    
    public static void bubbleSort(int[] data) {
        for(int i = 0; i < data.length - 2; i++) {
            for(int j = 0; j < data.length - 2; j++) {
                if(data[j] > data[j + 1]) swap(data, j, j + 1);
            }
        }
    }
/*
    private static int[] bubbleSort(int[] data, int index) {
        
    }

    private static int[] bubbleSort(int[] data, int index, int pass) {
        if(data[index] > data[index + 1]) data[index + 1] = data[index];
        if(index >= data.length - 2) return data;
    }
*/

    private static void swap(int[] data, int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
}
