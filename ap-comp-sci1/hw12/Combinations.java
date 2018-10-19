import java.util.Scanner;

public class Combinations {
    
    public Combinations() { }

    public void run() {
        Scanner sys = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = sys.nextInt();
        System.out.println("Enter an integer:");
        int b = sys.nextInt();
        System.out.println(combination(a,b));
    }

    private int combination(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    private int factorial(int a) {
        return (a == 1) ? 1 : 
            (a < 1) ? 0 : 
            factorial(a-1) * a;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        
        combinations.run();
    }

}
