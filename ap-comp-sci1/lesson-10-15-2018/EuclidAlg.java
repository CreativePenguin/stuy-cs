public class EuclidAlg {

    public static int gcd(int x, int y) {
	int r = x % y;
	return (r == 0) ? y : gcd(y, r);
    }

    public static int lcm(int x, int y) {
	int gcd = gcd(x,y);
	return (x * y) / gcd;
    }

    public static int countDigits(int a) {
	return (a > 0) ? countDigits(a /= 10) + 1 : 0;
    }

    private static int raiseToPower(int n, int k) {
        for(int i = 1; i < k; i++) n *= n;
        return n;
    }

    private static double raiseToPower(double n, int k) {
	return (k > 1) ? raiseToPower(n, k - 1) * n : n;
    }

    private static double raiseToPower(long n, int k) {
	return (k > 1) ? raiseToPower(n,k - 1) * n : n;
    }

    public static void main(String[] args) {
	System.out.println(gcd(4,2));
	System.out.println(gcd(5,3));
	System.out.println(gcd(100,50));
	System.out.println(gcd(694,254));

	System.out.println();
	
	System.out.println(lcm(4,2));
	System.out.println(lcm(324,2));
	System.out.println(lcm(1024,2056));
	System.out.println(lcm(1241,2045));

	System.out.println();
	
	System.out.println(countDigits(10));
	System.out.println(countDigits(33));
	System.out.println(countDigits(3357));
	System.out.println(countDigits(123456789));
        
        System.out.println();

        System.out.println(raiseToPower(10, 2));
        System.out.println(raiseToPower(10.0, 2));
    }

}
