public class QuadraticSolver {

    private static boolean isReal(double a, double b, double c) {
	return (b * b) - 4 * a * c >= 0;
    }

    private static boolean isUndefined(double a) {
	return a == 0;
    }

    private static String findRoot(double a, double b, double c) {
	double ans1 = (-1 * b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
	double ans2 = (-1 * b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
	return Double.toString(ans1) + " and " + Double.toString(ans2);
    }
    
    public static void main(String[] args) {
	double a = Double.parseDouble(args[0]);
	double b = Double.parseDouble(args[1]);
	double c = Double.parseDouble(args[2]);

	String val = isReal(a,b,c) ? null : "no real answers";
	val = isUndefined(a) ? "undefined" : val;
	val = val == null ? findRoot(a,b,c) : val;
	System.out.println(val);
    }
}
