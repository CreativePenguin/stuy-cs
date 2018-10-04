public class FunctionGrowth {
    public static void main(String[] args) {

	for(int input = 16; input <= 2048; input *= 2) {
	    double logN = Math.log(input);
	    System.out.print(logN + "\t");
	    double N = Math.log(input);
	    System.out.print(N + "\t");
	    double NlogN = input * Math.log(input);
	    System.out.print(NlogN + "\t");
	    double N2 = input * input;
	    System.out.print(N2 + "\t");
	    double N3 = input * input * input;
	    System.out.print(N3 + "\t");
	    double output = Math.pow(2,input);
	    System.out.println(output);
	}
    }
}
