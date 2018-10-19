import java.util.Scanner;

public class Combinations{

    // Assume n >= 0.
    private int factorial(int n){
	    int result = 1;
	    for (int i = 1; i <= n; i++){
	        result *= i;
	    }
	    return result;
    }

    // Assume n >= 0.
    private int factorialR(int n){
	    if (n <= 1) return 1;       // Base Case 
	    return n * factorialR(n - 1); // Linear Recursive Step
    }

    // Assume n >= 0 and 0 <= k <= n.
    // Explicit function that overflows with modest values of n.
    private int combinations(int n, int k){
	    return factorial(n)/factorial(n-k)/factorial(k);
    }


    // Assume n >= 0 and 0 <= k <= n.
    // Uses Pascal's Triangle
    private int combinationsR(int n, int k){
	    if ( k == 0 || n == k)  // first or last entry of a row ; Base Cases
	        return 1;
	    return combinationsR(n-1,k-1) + combinationsR(n-1,k); // Tree Recursive Step
	    // sums the 2 entries from the previous row
	}
  
    private int combinationsR2(int n, int k) {
        return (k == 0 || n == k) ? 1 :
            combinationsR2(n - 1, k - 1) * (n / k);
    }
    
    public void run(){
	    Scanner sys = new Scanner(System.in);
	    System.out.print("enter n: ");
	    int n = sys.nextInt();
	    System.out.print("enter k: ");
	    int k = sys.nextInt();
	    System.out.println("C(" + n + "," + k + ") : " + combinations(n,k));
	    System.out.println("C(" + n + "," + k + ") : " + combinationsR(n,k));
	    System.out.println("C(" + n + "," + k + ") : " + combinationsR2(n,k));
    }

    

    public static void main(String[] args){
	    new Combinations().run();
	}
}
