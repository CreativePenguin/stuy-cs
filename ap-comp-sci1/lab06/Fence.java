public class Fence {

    private static String buildFence(int input) {
	String val = "|";
	int counter = 1;
	while(input > 1 && counter < input) {
	    val += "---|";
	    counter++;
	}
	return (input < 0) ? "Positive #'s Only" : (input == 0) ? "" : val;
    }

    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	System.out.println(buildFence(input));
    }

}
