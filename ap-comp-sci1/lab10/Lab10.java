public class Lab10 {
    
    private int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    private int digitSum(int n) {
        return (n - 10 < 0) ? n : digitSum(n / 10) + n % 10;
    }

    private int digitalRoot(int n) {
        return (digitSum(n) - 10 < 0) ? digitSum(n) :
            digitalRoot(digitSum(n));
    }

    public static void main(String[] args) {
        Lab10 lab10 = new Lab10();

        System.out.println(lab10.gcd(7, 63));
        System.out.println(lab10.gcd(694, 254));
        System.out.println(lab10.gcd(20, 40));

        System.out.println();

        System.out.println(lab10.digitSum(1729));
        System.out.println(lab10.digitSum(2));
        System.out.println(lab10.digitSum(2767));

        System.out.println();
        
        System.out.println(lab10.digitalRoot(1729));
        System.out.println(lab10.digitalRoot(2));
        System.out.println(lab10.digitalRoot(2767));
    }

}
