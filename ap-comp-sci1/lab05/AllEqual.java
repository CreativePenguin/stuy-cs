public class AllEqual {
    private boolean equalsThree(String x, String y, String z) {
	int a = Integer.parseInt(x);
	int b = Integer.parseInt(y);
	int c = Integer.parseInt(z);
	return a == b && a == c;
    }

    public static void main(String[] args) {
	AllEqual allEqual = new AllEqual();
	String equal = allEqual.equalsThree(args[0], args[1], args[2]) ?
	    "equal":
	    "not equal";
	System.out.println(equal);
    }
}
