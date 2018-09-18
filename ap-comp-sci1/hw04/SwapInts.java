import java.util.Scanner;

public class SwapInts {
    private void run() {
	Scanner sys = new Scanner(System.in);
	System.out.println("Integer?");
	int n1 = sys.nextInt();
	System.out.println("Integer?");
	int n2 = sys.nextInt();
	int tempval = n1;
	System.out.println(n1 + "," + n2);
	n1 = n2;
	n2 = tempval;
	System.out.println(n1 + "," + n2);
    }
    public static void main(String[] args) {
	new SwapInts().run();
    }
}
