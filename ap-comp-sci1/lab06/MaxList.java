import java.util.Scanner;

public class MaxList {

    private static int SENTINEL = 0;
    
    public static void main(String[] args) {
	Scanner sys = new Scanner(System.in);
	int max = 0;
	int input = 0;
	while (true) {
	    System.out.print("Enter Int: ");
	    input = sys.nextInt();
	    if (input == SENTINEL) break;
	    max = (input > max) ? input : max;
	}
	
	System.out.println(max);
    }
}
