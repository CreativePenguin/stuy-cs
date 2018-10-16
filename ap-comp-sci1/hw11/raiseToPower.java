public class raiseToPower {
    
    private static int raiseToPower(int n, int k) {
       return (k > 1) ? raiseToPower(n, k - 1) * n : n;
    }

    private static double raiseToPower(double n, int k) {
       return (k > 1) ? raiseToPower(n, k - 1) * n : n;
    }

    private static long raiseToPower(long n, int k) {
       return (k > 1) ? raiseToPower(n, k - 1) * n : n;
    }

    public static void main(String[] args) {
        System.out.println(raiseToPower(10, 2));
        System.out.println(raiseToPower(10.0, 2));
    }

}
