public class DivisorPattern {
    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	for(int x = 1; x <= input; x++) {
	    for(int i = 1; i <= input; i++)
		System.out.print((x % i == 0 || i % x == 0) ? "* " : "  ");
	    System.out.println(x);
	}
    }
}
