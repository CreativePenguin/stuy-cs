import java.util.Scanner;

public class ScannerTest {

    private static int[] stringToArray(String userInput) {
	return null;
    }
    
    public static void main(String[] args) { /*
       	Scanner src = new Scanner(System.in);
	System.out.print("Input an array: ");
	String input = src.nextLine();
	System.out.println(stringToArray(input));
					     */
	String[] array = "test".split("e");
	for(String s : array)
	    System.out.println(s);
    }

}
