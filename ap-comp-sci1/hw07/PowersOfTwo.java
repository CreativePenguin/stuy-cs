public class PowersOfTwo {
    private static void run(int input) {
	for(int i = 0; i <= input; i++) {
	    System.out.println(i + " " + Math.pow(2,i));
	}
    }

    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);

	run(input);
    }
}
