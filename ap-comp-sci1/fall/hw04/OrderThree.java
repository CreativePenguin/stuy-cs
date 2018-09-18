import java.util.Scanner;

public class OrderThree {
    public static void main(String[] args) {
	Scanner sys = new Scanner(System.in);
	System.out.print("Integer 1: ");
	int x = sys.nextInt();
	System.out.print("Integer 2: ");
	int y = sys.nextInt();
	System.out.print("Integer 3: ");
	int z = sys.nextInt();
	int min = Math.min(x,Math.min(y,z));
	int mid = Math.max(
			Math.min(x,y),
			Math.max(Math.min(x,z),Math.min(y,z)));
	int max = Math.max(x,Math.max(y,z));
	System.out.println(min + "," + mid + "," + max);
    }
}
