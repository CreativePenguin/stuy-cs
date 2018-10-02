public class MaxArg {
    public static void main(String[] args) {
	int max = Integer.MIN_VALUE;
	
	for(String i : args) {
	    max = (max > Integer.parseInt(i)) ? max : Integer.parseInt(i);
	}

	System.out.println("Max arg: " + max);
    }
}
