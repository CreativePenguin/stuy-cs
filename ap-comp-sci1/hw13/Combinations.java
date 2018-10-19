import java.util.Scanner;


public class Combinations{

    // Assume n >= 0 and 0 <= k <= n.
    // A crude version which easily overflows
    // with modest values of n.
    private int combinations(int n, int k ){
	return factorial(n) / factorial(n-k) / factorial(k);

    }

  

    // Assume n >= 0.
    private int factorial(int n){
	int result = 1;
	for (int i = 1; i <= n; i++) result *= i;
	return result;
    }



    public void run(){
	Scanner sys  = new Scanner(System.in); 
	System.out.print("enter n: ");
	int n = sys.nextInt();
	System.out.print("enter k: ");
	int k = sys.nextInt();
	System.out.println("C(" + n + "," + k + "): " + combinations(n,k));
    }


    public static void main(String [] args){
	Combinations c = new Combinations();
        c.run();

    }

}
