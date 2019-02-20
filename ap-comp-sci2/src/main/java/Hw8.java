package src.main.java;

public class Hw8 {
    public static void selectionSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
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
        return min;
    }
}
