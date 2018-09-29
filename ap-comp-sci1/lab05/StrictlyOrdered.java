public class StrictlyOrdered {

    private static boolean isAscending(double x, double y, double z) {
	return x < y && y < z;
    }

    private static boolean isDescending(double x, double y, double z) {
	return x > y && y > z;
    }

    public static void main(String[] args) {
	double x = Double.parseDouble(args[0]);
	double y = Double.parseDouble(args[1]);
	double z = Double.parseDouble(args[2]);

	boolean val = isAscending(x,y,z) || isDescending(x,y,z);

	System.out.println(val);
    }
}
