public class ReverseDigits {

    public static int reverse(int input) {
	int divisor = 1;
	int val = 0;
	while(divisor <= input) {
	    divisor *= 10;
	    val *= 10;
	    val += (input % divisor) / (divisor / 10);
     	}
	return val;
    }

    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	System.out.println(reverse(input));
    }
    
}
