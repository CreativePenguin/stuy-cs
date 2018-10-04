public class CheckerBoard {
    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	for (int i = 0; i < input; i++) {
	    System.out.println( (i % 2 == 0) ? "* * * * *" : " * * * * *");
	}
    }
}
