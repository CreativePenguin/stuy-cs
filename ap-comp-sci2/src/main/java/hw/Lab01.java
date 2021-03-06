package hw;

import java.util.Scanner;

public class Lab01 {
    private class TwentyQuestions {
        Scanner src = new Scanner(System.in);
        public int search(int lo, int hi) {
            if(hi - lo == 1) return lo;
            int check = lo + (hi - lo) / 2;
            System.out.print("Less than " + check + "?");
            boolean isLessThan = src.nextBoolean(); 
            src.nextLine();
            return (isLessThan) ? search(lo, check) :
                search(check, hi);
        }
    }
    public static void main(String[] args) {
        Lab01.TwentyQuestions tQuestions = new Lab01().new TwentyQuestions();
        int n = Integer.parseInt(args[0]);
        int N = (int) Math.pow(2,n);
        System.out.print("Think of a number: ");
        System.out.println("between 0 and " + (N - 1));
        int v = tQuestions.search(0,N);
        System.out.println("Your number is " + v);
    }
}
