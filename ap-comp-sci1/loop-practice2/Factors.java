public class Factors {

    private static boolean isPrime(long input) {
	for(int i = 2; i < input; i++) {
	    if(input % i == 0) return false;
	}
	return true;
    }
    
    public static void main(String[] args) {
	long input = Long.parseLong(args[0]);

	while(!isPrime(input)) {
	    for(int i = 2; i < input; i++) {
		if(input % i == 0) {
		    input /= i;
		    System.out.print(i + " ");
		    break;
		}
	    }
	}
	System.out.println(input);
    }
}
