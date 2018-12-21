import java.util.Scanner;
import java.util.InputMismatchException;

public class CouponCollectorTest {

    /**
     * @author Winston Peng and Kevin Cai
     * Put in a number (when prompted)
     * The program will generate random numbers,
     * until it has generated all of the random integers up to
     * the number
     * The program repeats this several times for accuracy
     * Only possible input is an integer
     */

    /*
    private static double harmonicNumbersFormula(double n) {
        double val = 0;
        for(double i = 1; i <= n; i++) {
            val += (1 / i);
        }
        return val * n;
    }
    */
    
    private static int[] harmonicNumbers(int n, int counter) {
        int[] val = new int[counter];
        for(int j = 0; j < val.length; j++) {
            boolean[] possibleValues = new boolean[n];
            while(true) {
                boolean whoopdedoo = true;
                for(boolean i : possibleValues) {
                    if(!i) whoopdedoo = false;
                }
                if(whoopdedoo) break;
                int hand = 0;
                Double temp = Math.random() * n;
                hand = temp.intValue();
                possibleValues[hand] = true;
                val[j]++;
            }
        }
        return val;
    }

    private static int avg(int[] n) {
        int sum = 0;
        for(int i : n)
            sum += i;
        return sum / n.length;
    }
    
    /*
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
n    */
    
    private static void run() {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            int input = src.nextInt(); src.nextLine();
            System.out.println(avg(harmonicNumbers(input, 100)));
        } catch(InputMismatchException ex) {
            System.out.println("Input invalid");
            run();
        }
    }

    public static void main(String[] args) {
        run();
    }

}
