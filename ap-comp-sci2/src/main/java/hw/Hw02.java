package hw;

public class Hw02 {

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
