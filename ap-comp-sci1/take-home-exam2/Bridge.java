import java.util.Arrays;

public class Bridge {

    /**
     * @author Winston Peng and Kevin Cai
     * Some code is commented out
     * Commented code calcs for the most frequent card hand
     * Current code cals for the most frequent card out of 5-3-3-2, 
     * 4-4-3-2, and 4-3-3-3
     * It randomly generates card hands, and then finds which one
     * appears the most frequently
     * Just compile the code
     */

    /*
    private static int countArray(int[][] matrix, int[] array) {
        int counter = 0;
        for(int[] i : matrix) {
            if(Arrays.equals(array, i)) counter++;
        }
        return counter;
    }

    private static int[] findMax(int[][] matrix) {
        int[] counters = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            counters[i] = countArray(matrix, matrix[i]);
        }
        int max = 0; int index = 0;
        for(int i = 0; i < counters.length; i++) {
            if(counters[i] > max) {
                max = counters[i];
                index = i;
            }
        }
        return matrix[index];
    }
    */

    private static int[] findMax(int[][] matrix) {
        int[] counters = new int[3];
        int[][] options = { {5, 3, 3, 2},
                            {4, 4, 3, 2},
                            {4, 3, 3, 3} };
        for(int[] i : matrix) {
            for(int j = 0; j < counters.length; j++)
                if(Arrays.equals(i, options[j])) counters[j]++;
        }
        int max = 0; int index = 0;
        for(int i = 0; i < counters.length; i++) {
            if(counters[i] > max) {
                max = counters[i];
                index = i;
            }
        }
        return options[index];
    }

    private static int[] bridge() {
        int[][] hands = new int[100][4];
        for(int i = 0; i < 100; i++) {
            int[] hand = new int[4];
            for(int j = 0; j < 13; j++) {
                double rand = Math.random();
                if(rand <= 0.25) hand[0]++;
                else if(rand <= 0.5) hand[1]++;
                else if(rand <= 0.75) hand[2]++;
                else hand[3]++;
            }
            hands[i] = hand;
        }
        return findMax(hands);
    }

    public static void main(String[] args) {
        for(int i : bridge()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
