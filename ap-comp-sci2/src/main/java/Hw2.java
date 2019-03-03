package hw;

public class Hw2 {

    private static boolean isSorted(int[] data) {
        int prev = data[0];
        for(int i : data) {
            if(i < prev) {
                return false;
            }
            prev = i;
        }
        return true;
    }

}
