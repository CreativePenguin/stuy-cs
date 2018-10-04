public class Harmonic {
    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);

	double sum = 0;
	for(double i = 1; i <= input; i++) {
	    sum += 1 / i;
	}

	double approx = Math.log((double) input) + 0.57721;

	System.out.println("sum : " + sum);
	System.out.println("approx: " + approx);
    }
}
