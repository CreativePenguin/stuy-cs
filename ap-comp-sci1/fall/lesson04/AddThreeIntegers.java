/*
  prompt the user for 3 integers,
  store each integer in a variable,
  then compute and display the sum.
*/

//package declaration
package fall.lesson04;

//import statement
import java.util.Scanner;

//Class Definition
public class AddThreeIntegers {

    //a non-static method
    public void run() {
	Scanner sys = new Scanner(System.in);
	System.out.print("enter an integer: ");
	int n1 = sys.nextInt();
	System.out.print("enter an integer: ");
	int n2 = sys.nextInt();	
	System.out.print("enter an integer: ");
	int n3 = sys.nextInt();
	int sum = n1 + n2 + n3;
	System.out.println("The sum: " + sum);
    }
    
    // main method
    //A boilerplate is a common pattern. (The general format this program is in)
    public static void main(String[] args) {
	new AddThreeIntegers().run();
    }
}
