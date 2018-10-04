public class Hailstone {

    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	int i = input;
	int counter = 1;
	if (i <= 0) System.out.println("enter positive int");

	while(true) {
	    System.out.println(i);
	    if (i == 1) break;
	    else if (i % 2 == 0) i /= 2;
	    else i = i * 3 + 1;
	    counter += 1;
	}
	System.out.println("terms: " + counter);
    }
}
