public class RollLoadedDie {

    private static int run() {
	double rand = Math.random();

	for(int i = 0; i <= 5; i++) {
	    if(rand <= i / 8.0) return i;
	}
	
	return 6;
    }
    
    public static void main(String[] args) {
	System.out.println(run());
    }
}
