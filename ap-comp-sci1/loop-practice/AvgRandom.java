public class AvgRandom {
    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);

	double sum = 0;
	for(int i = 0; i < input; i++) {
	    double random = Math.random();
	    System.out.println("term " + i + " " + random);
	    sum += random;
	}
	System.out.println("mean  " + sum / input);
    }
}
	
