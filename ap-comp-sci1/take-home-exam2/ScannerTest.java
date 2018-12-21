import java.util.Scanner;

public class ScannerTest {

    private static int[] stringToArray(String userInput) {
	return null;
    }

    private static int popNumber(int[] n) {
        int maxCount = 0;
        int index = 0;
        int currentCount = 0;
        for(int i = 0; i < n.length; i++) {
            currentCount = 0;
            for(int j : n) {
                if(n[i] == j) currentCount++;
            }
            if(currentCount > maxCount) {
                maxCount = currentCount;
                index = i;
            }
        }
        return n[index];
    }
    
    public static void main(String[] args) { /*
       	Scanner src = new Scanner(System.in);
	System.out.print("Input an array: ");
	String input = src.nextLine();
	System.out.println(stringToArray(input));
	String[] array = "test".split("e");
	for(String s : array)
	    System.out.println(s);
        int[][] matrix = { {1, 2, 3},
                           {4, 5, 6} };
        int[][] mat = { {1, 2, 3},
                        {4, 5, 6} };
        int[] test = new int[2];
        test[0] = 3;
        int[] tesa = new int[2];
        tesa[0] = 3;
        System.out.println(matrix == mat);
        System.out.println(matrix.equals(mat));
        System.out.println(test.equals(tesa));
        */
        for(int i : new int[10]) {
            int j = 1;
        }
        int[] array = {1, 2, 2, 3, 3, 3, 3};
        System.out.println(popNumber(array));
    }

}
